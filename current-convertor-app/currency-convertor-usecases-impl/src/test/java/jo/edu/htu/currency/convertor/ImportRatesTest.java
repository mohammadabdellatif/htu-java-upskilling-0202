package jo.edu.htu.currency.convertor;

import com.mysql.cj.jdbc.MysqlDataSource;
import jo.edu.htu.currency.model.ExchangeRateRepository;
import jo.edu.htu.currency.model.DBExchangeRateRepository;
import org.apache.commons.dbcp2.BasicDataSource;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class ImportRatesTest {

    public static void main(String[] args) throws SQLException {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("root");
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/countries?serverTimezone=UTC");
        basicDataSource.setInitialSize(2);
        try (Connection connection = basicDataSource.getConnection()) {
        }
//        MysqlDataSource dataSource = new MysqlDataSource();
//        dataSource.setUser("root");
//        dataSource.setPassword("root");
//        dataSource.setURL("jdbc:mysql://localhost:3306/countries?serverTimezone=UTC");
        ExchangeRateRepository repository = new DBExchangeRateRepository(basicDataSource);
        ImportRatesHandler importRatesHandler = new BISImportRatesHandler(repository);

        long startTime = System.currentTimeMillis();
        System.out.println("start processing: " + new Date());
        ImportRequest request = new ImportRequest(Paths.get(".", "table-i3-e.csv"));
        importRatesHandler.importRates(request);
        long endTime = System.currentTimeMillis();
        System.out.println("import took: " + ((endTime - startTime) / 1000) + " seconds");
        System.out.println("end: " + new Date());
    }
}
