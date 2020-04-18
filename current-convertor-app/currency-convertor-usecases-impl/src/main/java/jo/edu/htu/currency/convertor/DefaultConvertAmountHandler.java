package jo.edu.htu.currency.convertor;

import java.math.BigDecimal;
// SOLID
// Single responsibility
// Open for extension closed for modification (design should be decoupled) (break)
// Liskov principle
// Interface Segregation
// Dependency injection

public class DefaultConvertAmountHandler implements ConvertAmountHandler {
    // coupling
    private GetRateHandler handler;

    public DefaultConvertAmountHandler(GetRateHandler handler) {
        this.handler = handler;
    }

    @Override
    public ConvertResult convert(ConvertRequest request) {
        GetRateResult rateResult = handler.getRate(new GetRateRequest(request.getFrom(), request.getTo()));
        BigDecimal rate = rateResult.getRate();
        BigDecimal converted = request.getAmount().multiply(rate);
        return new ConvertResult(converted, rate);
    }
}
