package jo.edu.htu.currency.convertor;

import jo.edu.htu.currency.model.ExchangeRateRepository;
import jo.edu.htu.currency.model.ExchangeRateTO;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DBGetRateHandler implements GetRateHandler {
    private ExchangeRateRepository repository;

    public DBGetRateHandler(ExchangeRateRepository repository) {
        this.repository = repository;
    }

    @Override
    public GetRateResult getRate(GetRateRequest request) {
        if (request.getFrom().equals("USD")) {
            ExchangeRateTO rate = repository.findRateByToCode(request.getTo());
            return new GetRateResult(rate.getRate());
        }
        String from = request.getFrom();
        String to = request.getTo();
        ExchangeRateTO usdToFrom = repository.findRateByToCode(from);
        ExchangeRateTO usdToTo = repository.findRateByToCode(to);
        BigDecimal rate = new BigDecimal(1 / usdToFrom.getRate().doubleValue());
        rate = rate.setScale(usdToTo.getRate().scale(), RoundingMode.DOWN);
        rate = rate.multiply(usdToTo.getRate());
        return new GetRateResult(rate);
    }
}
