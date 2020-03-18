package jo.edu.htu.convertor;

public class YahooConvertorApp extends CurrencyConvertorApp {

    protected double getRate(String codeFrom, String codeTo) {
        // fetch from yahoo
        return 0.7;
    }
}
