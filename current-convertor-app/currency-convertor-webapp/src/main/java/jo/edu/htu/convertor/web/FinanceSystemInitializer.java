package jo.edu.htu.convertor.web;

import jo.edu.htu.currency.convertor.*;
import jo.edu.htu.currency.model.DBExchangeRateRepository;
import jo.edu.htu.currency.model.ExchangeRateRepository;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Set;

public class FinanceSystemInitializer implements ServletContainerInitializer {

    // prepare application components (aka use-cases)
    // prepare the servlet (web components) instances
    // pass the servlet instances to the ServletContext
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        System.out.println("server name: " + ctx.getVirtualServerName());
        System.out.println("server info: " + ctx.getServerInfo());
        System.out.println("deployed context path: " + ctx.getContextPath());

        ExchangeRateRepository repository = prepareRepository();

        GetRateHandler getRateHandler = new DBGetRateHandler(repository);
        ListRatesHandler listRatesHandler = new DefaultListRatesHandler(getRateHandler);
        ListAvailableCurrenciesHandler listAvailableCurrenciesHandler = new DefaultListAvailableCurrenciesHandler(repository);

        registerListRatesServlet(ctx, listRatesHandler);
        registerCurrenciesSelectionServlet(ctx, listAvailableCurrenciesHandler);
    }

    private void registerCurrenciesSelectionServlet(ServletContext ctx, ListAvailableCurrenciesHandler listAvailableCurrenciesHandler) {
        CurrenciesSelectionServlet currenciesSelectionServlet = new CurrenciesSelectionServlet(listAvailableCurrenciesHandler);
        ServletRegistration.Dynamic servletRegistration = ctx.addServlet("currenciesSelectionServlet", currenciesSelectionServlet);
        servletRegistration.addMapping("/selectCurrencies");
    }

    private void registerListRatesServlet(ServletContext ctx, ListRatesHandler listRatesHandler) {
        ListRatesServlet listRatesServlet = new ListRatesServlet(listRatesHandler);
        ServletRegistration.Dynamic servletRegistration = ctx.addServlet("listRatesServlet", listRatesServlet);
        servletRegistration.addMapping("/rates");
    }

    private ExchangeRateRepository prepareRepository() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/countries");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return new DBExchangeRateRepository(dataSource);
    }
}
