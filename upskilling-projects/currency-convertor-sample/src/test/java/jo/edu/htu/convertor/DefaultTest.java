package jo.edu.htu.convertor;

public class DefaultTest {

    public static void main(String[] args) {
        CodePredicate.alwaysTrue();
        RateSupplier supplier = new MockingRateSupplier();

        System.out.println(supplier.getRate("USD", "JOD"));
        System.out.println(supplier.getRateAsBigDecimal("USD", "JOD", 3));
    }
}
