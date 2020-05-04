package jo.edu.htu.convertor.web;

import jo.edu.htu.currency.convertor.CurrenciesResult;
import jo.edu.htu.currency.convertor.DefaultListAvailableCurrenciesHandler;
import jo.edu.htu.currency.convertor.ListAvailableCurrenciesHandler;
import jo.edu.htu.currency.model.DBExchangeRateRepository;
import jo.edu.htu.currency.model.ExchangeRateRepository;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CurrenciesSelectionServlet extends HttpServlet {

    private ListAvailableCurrenciesHandler listAvailableCurrenciesHandler;

    @Override
    public void init() throws ServletException {
        listAvailableCurrenciesHandler = prepareListRatesHandler();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CurrenciesResult currenciesResult = listAvailableCurrenciesHandler.listAll();
        req.setAttribute("codes", currenciesResult.getCodes());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/selectCurrencies.jsp");
        requestDispatcher.forward(req, resp);
    }

    private ListAvailableCurrenciesHandler prepareListRatesHandler() {
        BasicDataSource dataSource = new BasicDataSource();
        ServletConfig servletConfig = getServletConfig();
        dataSource.setUrl(servletConfig.getInitParameter("db_url"));
        dataSource.setUsername(servletConfig.getInitParameter("db_user"));
        dataSource.setPassword(servletConfig.getInitParameter("db_pass"));
        dataSource.setDriverClassName(servletConfig.getInitParameter("db_driver"));
        ExchangeRateRepository repository = new DBExchangeRateRepository(dataSource);
        return new DefaultListAvailableCurrenciesHandler(repository);
    }
}
