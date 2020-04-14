package jo.edu.htu.currency.convertor;

import java.math.BigDecimal;

public class ConvertRequest {
    private final String from;
    private final String to;
    private final BigDecimal amount;

    public ConvertRequest(String from, String to, BigDecimal amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
