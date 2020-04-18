package jo.edu.htu.currency.convertor;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DefaultListRatesHandler implements ListRatesHandler {

    private GetRateHandler rateHandler;

    public DefaultListRatesHandler(GetRateHandler rateHandler) {
        this.rateHandler = rateHandler;
    }

    @Override
    public ListRatesResult getRates(ListRatesRequest request) {
        String from = request.getFrom();
        Set<String> toCodes = request.getToCodes();
        Map<String, BigDecimal> rates = new HashMap<>();
        for (String toCode : toCodes) {
            GetRateResult rate = rateHandler.getRate(new GetRateRequest(from, toCode));
            rates.put(toCode, rate.getRate());
        }
        return new ListRatesResult(rates);
    }
}
