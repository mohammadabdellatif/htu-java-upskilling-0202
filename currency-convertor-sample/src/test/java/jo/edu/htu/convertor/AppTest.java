package jo.edu.htu.convertor;

public class AppTest {

    public static void main(String[] args) {
    }


    public void runMe() {
        Predicates predicates = new Predicates();

        Predicates.TruePredicate truePredicate = predicates.new TruePredicate();
        Predicates.FalsePredicate falsePredicate = new Predicates.FalsePredicate();


        RateSupplier rateSupplier = new MockingRateSupplier();
        CodePredicate codePredicate = new MockingCodePredicate();
        CurrencyConvertorApp app = new CurrencyConvertorApp(rateSupplier, codePredicate);

        app.run();
    }

}
