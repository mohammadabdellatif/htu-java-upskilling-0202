package jo.edu.htu.convertor;

public class AppTest {

    public static void main(String[] args) {
        AppTest test = new AppTest(0.9);
        test.runMe();
    }

    private double rateToUse;

    public AppTest(double rateToUse) {
        this.rateToUse = rateToUse;
    }

    public void runMe() {
        Predicates.TruePredicate truePredicate = new Predicates.TruePredicate();
        RateSupplier rateSupplier = new DummySupplier();
        CurrencyConvertorApp app = new CurrencyConvertorApp(rateSupplier, truePredicate);
        app.run();
    }

    private class DummySupplier implements RateSupplier {

        @Override
        public double getRate(String codeCode, String codeTo) {
            return rateToUse;
        }
    }
}
