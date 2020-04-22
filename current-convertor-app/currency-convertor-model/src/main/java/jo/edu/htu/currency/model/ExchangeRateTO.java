package jo.edu.htu.currency.model;

import java.math.BigDecimal;

public class ExchangeRateTO {
    private String toCode;
    private BigDecimal rate;

    public String getToCode() {
        return toCode;
    }

    public void setToCode(String toCode) {
        this.toCode = toCode;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
