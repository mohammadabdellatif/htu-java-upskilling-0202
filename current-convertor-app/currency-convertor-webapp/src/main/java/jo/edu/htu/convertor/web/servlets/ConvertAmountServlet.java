package jo.edu.htu.convertor.web.servlets;

import jo.edu.htu.currency.convertor.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.math.BigDecimal;

public class ConvertAmountServlet extends HttpServlet {
    public static final String LAST_CONVERT_REQUEST_COOKIE = "lastConvertRequest";
    private final ListAvailableCurrenciesHandler listAvailableCurrenciesHandler;
    private final ConvertAmountHandler convertAmountHandler;

    public ConvertAmountServlet(ListAvailableCurrenciesHandler listAvailableCurrenciesHandler,
                                ConvertAmountHandler convertAmountHandler) {
        this.listAvailableCurrenciesHandler = listAvailableCurrenciesHandler;
        this.convertAmountHandler = convertAmountHandler;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardToView(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String from = req.getParameter("from");
        String to = req.getParameter("to");
        String amount = req.getParameter("amount");

        ConvertRequest request = new ConvertRequest(from, to, new BigDecimal(amount));
        ConvertResult convertResult = convertAmountHandler.convert(request);

        req.setAttribute("convertedAmount", convertResult.getAmount());
        req.setAttribute("rate", convertResult.getRate());

        HttpSession session = req.getSession(true);
        System.out.println("session id: " + session.getId());
        session.setAttribute("lastFrom", from);
        session.setAttribute("lastTo", to);
        session.setAttribute("lastAmount", amount);

        forwardToView(req, resp);
    }

    private void addHistoryCookie(HttpServletRequest req, HttpServletResponse resp, String from, String to, String amount) {
        Cookie cookie = new Cookie("lastConvertRequest", from + "-" + to + "-" + amount);
        cookie.setPath(req.getContextPath() + req.getServletPath());
        cookie.setMaxAge(60 * 60);
        cookie.setHttpOnly(true);
        resp.addCookie(cookie);
    }

    private void forwardToView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        checkLastConvertRequest(req);
        CurrenciesResult currenciesResult = listAvailableCurrenciesHandler.listAll();

        req.setAttribute("currencies", currenciesResult.getCodes());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/convert.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void checkLastConvertRequest(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        if (cookies == null)
            return;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equalsIgnoreCase(LAST_CONVERT_REQUEST_COOKIE)) {
                String value = cookie.getValue();
                String[] split = value.split("-");
                req.setAttribute("lastFrom", split[0]);
                req.setAttribute("lastTo", split[1]);
                req.setAttribute("lastAmount", split[2]);
                return;
            }
        }
    }
}
