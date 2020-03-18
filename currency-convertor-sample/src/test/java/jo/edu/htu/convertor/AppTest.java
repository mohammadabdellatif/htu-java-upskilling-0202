package jo.edu.htu.convertor;

public class AppTest {

    public static void main(String[] args) {
        // Mocking
        RateSupplier rateSupplier = new MockingRateSupplier();
        CurrencyConvertorApp app = new CurrencyConvertorApp(rateSupplier);
        app.run();
    }
}
