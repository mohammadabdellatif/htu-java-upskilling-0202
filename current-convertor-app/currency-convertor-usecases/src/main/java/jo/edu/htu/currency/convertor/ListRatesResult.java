package jo.edu.htu.currency.convertor;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class ListRatesResult {

    private Map<String, BigDecimal> rates;

    public ListRatesResult(Map<String, BigDecimal> rates) {
        this.rates = Collections.unmodifiableMap(rates);
    }

    public Map<String, BigDecimal> getAllRates() {
        return rates;
    }

    public BigDecimal getRateFor(String to) {
        return rates.get(to);
    }

    public Set<String> getCodes() {
        return rates.keySet();
    }
}
