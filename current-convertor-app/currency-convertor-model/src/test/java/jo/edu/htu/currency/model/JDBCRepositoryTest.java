package jo.edu.htu.currency.model;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.util.List;

public class JDBCRepositoryTest {

    public static void main(String[] args) {
        MysqlDataSource factory;
        MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
        dataSource.setURL("jdbc:mysql://localhost:3306/countries?serverTimezone=UTC");
        dataSource.setUser("root");
        dataSource.setPassword("root");

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/countries?serverTimezone=UTC");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("root");
        basicDataSource.setMaxTotal(10);
        basicDataSource.setMinIdle(3);
//        ExchangeRateTO exchangeRateTO = new ExchangeRateTO();
//        exchangeRateTO.setToCode("JOD");
//        exchangeRateTO.setRate(BigDecimal.valueOf(0.71));
//
//        testInsert(exchangeRateTO);
        testFind(basicDataSource);
    }

    private static void testFind(DataSource dataSource) {
        DBExchangeRateRepository rateRepository = new DBExchangeRateRepository(dataSource);
        ExchangeRateTO exchangeRate = rateRepository.findRateByToCode("JOD");
        System.out.println(exchangeRate);
    }

    private static void testInsert(ExchangeRateTO exchangeRateTO, DataSource dataSource) {
        ExchangeRateRepository repository = new DBExchangeRateRepository(dataSource);
        repository.insert(exchangeRateTO);
        System.out.println("done");
    }

    private static void testReadAll(DataSource dataSource) {
        ExchangeRateRepository repository = new DBExchangeRateRepository(dataSource);
        List<ExchangeRateTO> exchangeRateTOS = repository.listAllRates();

        for (ExchangeRateTO exchangeRateTO : exchangeRateTOS) {
            System.out.println(exchangeRateTO);
        }
    }
}
