package jo.edu.htu.convertor.web.initializers;

import jo.edu.htu.convertor.web.servlets.ConvertAmountServlet;
import jo.edu.htu.convertor.web.servlets.CurrenciesSelectionServlet;
import jo.edu.htu.convertor.web.servlets.ImportBISServlet;
import jo.edu.htu.convertor.web.servlets.ListRatesServlet;
import jo.edu.htu.currency.convertor.*;
import jo.edu.htu.currency.model.DBExchangeRateRepository;
import jo.edu.htu.currency.model.ExchangeRateRepository;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import java.util.Set;

// Java SE (Service Loader) https://docs.oracle.com/javase/7/docs/api/java/util/ServiceLoader.html
//ServiceLoader<ServiceContainerInitializer> services = ServiceLoader.load(ServiceContainerInitializer.class);
// Iterator<ServiceContainerInitializer> iterator = services.iterator();
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
        ConvertAmountHandler convertAmountHandler = new DefaultConvertAmountHandler(getRateHandler);
        ImportRatesHandler importRatesHandler = new BISImportRatesHandler(repository);

        registerListRatesServlet(ctx, listRatesHandler);
        registerCurrenciesSelectionServlet(ctx, listAvailableCurrenciesHandler);
        registerConvertAmountServlet(ctx, listAvailableCurrenciesHandler, convertAmountHandler);
        registerImportServlet(ctx, importRatesHandler);
    }

    private void registerImportServlet(ServletContext ctx, ImportRatesHandler importRatesHandler) {
        ServletRegistration.Dynamic registration = ctx.addServlet("importRatesServlet", new ImportBISServlet(importRatesHandler));
        registration.addMapping("/importBIS");
        MultipartConfigElement multipartConfig = new MultipartConfigElement(
                null,
                1024 * 1024 * 2,
                1024 * 1024 * 2,
                1024 * 512);

        registration.setMultipartConfig(multipartConfig);
    }

    private void registerConvertAmountServlet(ServletContext ctx,
                                              ListAvailableCurrenciesHandler listAvailableCurrenciesHandler,
                                              ConvertAmountHandler convertAmountHandler) {
        ConvertAmountServlet convertAmountServlet = new ConvertAmountServlet(listAvailableCurrenciesHandler, convertAmountHandler);
        ServletRegistration.Dynamic servletRegistration = ctx.addServlet("convertAmountServlet", convertAmountServlet);
        servletRegistration.addMapping("/convert");
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
        dataSource.setUrl("jdbc:mysql://localhost:3306/countries?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return new DBExchangeRateRepository(dataSource);
    }
}
