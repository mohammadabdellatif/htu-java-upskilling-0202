package jo.edu.htu.convertor;

import java.util.function.Supplier;

public class AppTest {

    public static void main(String[] args) {
        AppTest test = new AppTest(0.9) {

        };
        test.runMe();
    }

    private double rateToUse = 0.9;

    public AppTest(double rate) {
        this.rateToUse = rate;
    }

    public void runMe() {

        CodePredicate falsePredicate = code -> false;
        CodePredicate truePredicate = (code) -> true;
        RateSupplier rateSupplier = (codeCode, codeTo) -> rateToUse;

        //CurrencyConvertorApp app = new CurrencyConvertorApp(rateSupplier, truePredicate);
        //CurrencyConvertorApp app = new CurrencyConvertorApp((f, t) -> rateToUse, c -> true);
        //CurrencyConvertorApp app = new CurrencyConvertorApp((f, t) -> rateToUse, CodePredicate.ALWAYS_TRUE);
        CurrencyConvertorApp app = new CurrencyConvertorApp((f, t) -> rateToUse, CodePredicate.alwaysTrue());
        app.run();
    }

    private class DummySupplier implements RateSupplier {

        @Override
        public double getRate(String codeCode, String codeTo) {
            return rateToUse;
        }
    }
}
