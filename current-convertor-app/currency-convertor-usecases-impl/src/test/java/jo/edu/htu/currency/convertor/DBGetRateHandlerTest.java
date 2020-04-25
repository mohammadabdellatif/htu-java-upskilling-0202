package jo.edu.htu.currency.convertor;

import com.mysql.cj.jdbc.MysqlDataSource;
import jo.edu.htu.currency.model.ExchangeRateRepository;
import jo.edu.htu.currency.model.DBExchangeRateRepository;

public class DBGetRateHandlerTest {

    public static void main(String[] args) {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setURL("jdbc:mysql://localhost:3306/countries?serverTimezone=UTC");
        ExchangeRateRepository repository = new DBExchangeRateRepository(dataSource);
        GetRateHandler getRateHandler = new DBGetRateHandler(repository);

        GetRateResult rate = getRateHandler.getRate(new GetRateRequest("JOD", "USD"));
        System.out.println(rate.getRate());
    }
}
