package jo.edu.htu.currency.convertor;

import java.util.Collections;
import java.util.Set;

public class CurrenciesResult {

    private Set<String> codes;

    public CurrenciesResult(Set<String> codes) {
        this.codes = Collections.unmodifiableSet(codes);
    }

    public Set<String> getCodes() {
        return codes;
    }
}
