package jo.edu.htu.currency.convertor;

import java.math.BigDecimal;

public class GetRateResult {
    private final BigDecimal rate;

    public GetRateResult(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getRate() {
        return rate;
    }
}
