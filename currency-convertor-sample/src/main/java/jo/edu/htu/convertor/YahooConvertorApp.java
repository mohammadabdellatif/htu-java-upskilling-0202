package jo.edu.htu.convertor;

public class YahooConvertorApp extends CurrencyConvertorApp {

    public YahooConvertorApp(RateSupplier rateSupplier) {
        super(rateSupplier);
    }

    protected double getRate(String codeFrom, String codeTo) {
        // fetch from yahoo
        return 0.7;
    }
}
