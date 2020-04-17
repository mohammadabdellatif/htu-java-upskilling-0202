package jo.edu.htu.currency.convertor;

import java.util.Collections;
import java.util.Set;

public class ListRatesRequest {

    private final String from;
    private final Set<String> toCodes;

    public ListRatesRequest(String from, Set<String> toCodes) {
        this.from = from;
        this.toCodes = Collections.unmodifiableSet(toCodes);
    }

    public String getFrom() {
        return from;
    }

    public Set<String> getToCodes() {
        return toCodes;
    }
}
