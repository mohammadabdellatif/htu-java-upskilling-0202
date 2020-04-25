package jo.edu.htu.currency.convertor;

import jo.edu.htu.currency.model.ExchangeRateRepository;
import jo.edu.htu.currency.model.DBExchangeRateRepository;

public class DBGetRateHandlerTest {

    public static void main(String[] args) {
        ExchangeRateRepository repository = new DBExchangeRateRepository();
        GetRateHandler getRateHandler = new DBGetRateHandler(repository);

        GetRateResult rate = getRateHandler.getRate(new GetRateRequest("JOD", "USD"));
        System.out.println(rate.getRate());
    }
}
