package jo.edu.htu.convertor;

import jo.edu.htu.currency.convertor.*;
import jo.edu.htu.currency.model.DBExchangeRateRepository;
import jo.edu.htu.currency.model.ExchangeRateRepository;
import org.apache.commons.dbcp2.BasicDataSource;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/countries");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        ExchangeRateRepository repository = new DBExchangeRateRepository(dataSource);

        ImportRatesHandler importRatesHandler = new BISImportRatesHandler(repository);
        GetRateHandler rateHandler = new DBGetRateHandler(repository);

        ListRatesHandler listRatesHandler = new DefaultListRatesHandler(rateHandler);
        ConvertAmountHandler convertAmountHandler = new DefaultConvertAmountHandler(rateHandler);
        ConsoleApp app = new ConsoleApp(rateHandler, convertAmountHandler);

        app.run();
    }
}
