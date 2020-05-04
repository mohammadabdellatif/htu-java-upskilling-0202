package jo.edu.htu.currency.convertor;

import jo.edu.htu.currency.model.ExchangeRateRepository;
import jo.edu.htu.currency.model.ExchangeRateTO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DefaultListAvailableCurrenciesHandler implements ListAvailableCurrenciesHandler {

    private ExchangeRateRepository rateRepository;

    public DefaultListAvailableCurrenciesHandler(ExchangeRateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    @Override
    public CurrenciesResult listAll() {
        List<ExchangeRateTO> exchangeRateTOS = rateRepository.listAllRates();
        Set<String> currencies = new HashSet<>();
        for (ExchangeRateTO exchangeRateTO : exchangeRateTOS) {
            currencies.add(exchangeRateTO.getToCode());
        }
        currencies.add("USD");
        return new CurrenciesResult(currencies);
    }
}
