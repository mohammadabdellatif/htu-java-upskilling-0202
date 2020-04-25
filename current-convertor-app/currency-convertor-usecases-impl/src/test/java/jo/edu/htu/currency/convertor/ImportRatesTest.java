package jo.edu.htu.currency.convertor;

import com.mysql.cj.jdbc.MysqlDataSource;
import jo.edu.htu.currency.model.ExchangeRateRepository;
import jo.edu.htu.currency.model.DBExchangeRateRepository;

import java.nio.file.Paths;

public class ImportRatesTest {

    public static void main(String[] args) {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setURL("jdbc:mysql://localhost:3306/countries?serverTimezone=UTC");
        ExchangeRateRepository repository = new DBExchangeRateRepository(dataSource);
        ImportRatesHandler importRatesHandler = new BISImportRatesHandler(repository);

        ImportRequest request = new ImportRequest(Paths.get(".", "table-i3-e.csv"));
        importRatesHandler.importRates(request);
    }
}
