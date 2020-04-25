package jo.edu.htu.currency.model;

import java.math.BigDecimal;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExchangeRateTO that = (ExchangeRateTO) o;
        return Objects.equals(toCode, that.toCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(toCode);
    }

    @Override
    public String toString() {
        return "ExchangeRateTO{" +
                "toCode='" + toCode + '\'' +
                ", rate=" + rate +
                '}';
    }
}
