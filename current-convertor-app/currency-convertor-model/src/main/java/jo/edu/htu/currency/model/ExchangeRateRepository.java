package jo.edu.htu.currency.model;

import java.util.List;

// DAO -> Data Access Object
// CRUD (Create, Read, Update, Delete)
public interface ExchangeRateRepository {

    void insert(ExchangeRateTO exchangeRateTO);

    void update(ExchangeRateTO exchangeRateTO);

    ExchangeRateTO findRateByToCode(String code);

    List<ExchangeRateTO> listAllRates();

    void insert(Iterable<ExchangeRateTO> rates);
}
