package jo.edu.htu.currency.model;

import java.util.List;

// DAO -> Data Access Object
public interface ExchangeRateDao {

    void insert(ExchangeRateTO exchangeRateTO);

    void update(ExchangeRateTO exchangeRateTO);

    void delete(String toCode);

    List<ExchangeRateTO> listAllRates();
}
