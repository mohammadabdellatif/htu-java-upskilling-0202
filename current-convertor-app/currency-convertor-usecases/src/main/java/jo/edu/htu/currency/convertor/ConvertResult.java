package jo.edu.htu.currency.convertor;

import java.math.BigDecimal;

public class ConvertResult {
    private final BigDecimal amount;
    private final BigDecimal rate;

    public ConvertResult(BigDecimal amount, BigDecimal rate) {
        this.amount = amount;
        this.rate = rate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getRate() {
        return rate;
    }
}
