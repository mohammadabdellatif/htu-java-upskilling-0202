package jo.edu.htu.convertor;

public class AppTest {

    public static void main(String[] args) {
        RateSupplier rateSupplier = new MockingRateSupplier();
        CodePredicate codePredicate = new MockingCodePredicate();
        CurrencyConvertorApp app = new CurrencyConvertorApp(rateSupplier, codePredicate);

        app.run();
    }
}
