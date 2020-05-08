package jo.edu.htu.convertor.web.servlets;

import jo.edu.htu.currency.convertor.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

public class ConvertAmountServlet extends HttpServlet {
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

        forwardToView(req, resp);
    }

    private void forwardToView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CurrenciesResult currenciesResult = listAvailableCurrenciesHandler.listAll();

        req.setAttribute("currencies", currenciesResult.getCodes());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/convert.jsp");
        requestDispatcher.forward(req, resp);
    }
}
