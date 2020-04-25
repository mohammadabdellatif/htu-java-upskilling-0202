package jo.edu.htu.currency.model;

import java.math.BigDecimal;
import java.util.List;

public class JDBCRepositoryTest {

    public static void main(String[] args) {
//        ExchangeRateTO exchangeRateTO = new ExchangeRateTO();
//        exchangeRateTO.setToCode("JOD");
//        exchangeRateTO.setRate(BigDecimal.valueOf(0.71));
//
//        testInsert(exchangeRateTO);
        testFind();
    }

    private static void testFind() {
        JDBCExchangeRateRepository rateRepository = new JDBCExchangeRateRepository();
        ExchangeRateTO exchangeRate = rateRepository.findRateByToCode("JOD");
        System.out.println(exchangeRate);
    }

    private static void testInsert(ExchangeRateTO exchangeRateTO) {
        ExchangeRateRepository repository = new JDBCExchangeRateRepository();
        repository.insert(exchangeRateTO);
        System.out.println("done");
    }

    private static void testReadAll() {
        ExchangeRateRepository repository = new JDBCExchangeRateRepository();
        List<ExchangeRateTO> exchangeRateTOS = repository.listAllRates();

        for (ExchangeRateTO exchangeRateTO : exchangeRateTOS) {
            System.out.println(exchangeRateTO);
        }
    }
}
