package jo.edu.htu.convertor.web;

import jo.edu.htu.currency.convertor.*;
import jo.edu.htu.currency.model.DBExchangeRateRepository;
import jo.edu.htu.currency.model.ExchangeRateRepository;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;

//@WebServlet(name = "ListRatesServlet", urlPatterns = "/rates", loadOnStartup = 1)
public class ListRatesServlet extends HttpServlet {
    private ListRatesHandler ratesHandler;
    private BasicDataSource dataSource;

    @Override
    public void init() throws ServletException {
        System.out.println("servlet is initialized");
        this.ratesHandler = prepareListRatesHandler();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("handle service request");
        HashSet<String> toCodes = new HashSet<>();
        String fromCode = request.getParameter("fromCode");
        String[] toCodesParams = request.getParameterValues("toCodes");
        if (fromCode == null || toCodesParams == null || toCodesParams.length == 0) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "You should pass fromCode and toCodes parameters");
            return;
        }

        toCodes.addAll(Arrays.asList(toCodesParams));
        ListRatesResult rates = ratesHandler.getRates(new ListRatesRequest(fromCode, toCodes));

        Map<String, BigDecimal> allRates = rates.getAllRates();
        renderView(response, fromCode, allRates);
    }

    private void renderView(HttpServletResponse response, String fromCode, Map<String, BigDecimal> allRates) throws IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        Date systemDate = new Date();
        writer.println("<html>");
        writer.println("<body>");
        writer.println("The time on server is: " + systemDate);
        writer.println("<p>The rates from ");
        writer.println(fromCode);
        writer.println(":</p>");
        writer.println("<table class=\"table-bordered\" border=\"1\">");
        writer.println("<thead><tr><th>Currency</th><th>Rate</th></tr></thead>");
        writer.println("<tbody>");
        for (String currency : allRates.keySet()) {
            writer.println("<tr>");
            writer.println("<td>" + currency + "</td><td>" + allRates.get(currency) + "</td>");
            writer.println("</tr>");
        }
        writer.println("</tbody>");
        writer.println("</table>");
        writer.println("</body>");
        writer.println("</html>");
    }

    private ListRatesHandler prepareListRatesHandler() {
        dataSource = new BasicDataSource();
        ServletConfig servletConfig = getServletConfig();
        dataSource.setUrl(servletConfig.getInitParameter("db_url"));
        dataSource.setUsername(servletConfig.getInitParameter("db_user"));
        dataSource.setPassword(servletConfig.getInitParameter("db_pass"));
        dataSource.setDriverClassName(servletConfig.getInitParameter("db_driver"));
        ExchangeRateRepository repository = new DBExchangeRateRepository(dataSource);
        GetRateHandler getRateHandler = new DBGetRateHandler(repository);
        return new DefaultListRatesHandler(getRateHandler);
    }

    @Override
    public void destroy() {
        System.out.println("servlet to be destroyed");
        try {
            dataSource.close();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
