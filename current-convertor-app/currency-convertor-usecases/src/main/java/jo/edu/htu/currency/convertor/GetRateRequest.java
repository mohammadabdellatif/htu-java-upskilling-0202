package jo.edu.htu.currency.convertor;

public class GetRateRequest {
    private final String from;
    private final String to;

    public GetRateRequest(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
}
