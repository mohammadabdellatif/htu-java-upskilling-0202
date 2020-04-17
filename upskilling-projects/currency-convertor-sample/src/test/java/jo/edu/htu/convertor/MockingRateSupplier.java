package jo.edu.htu.convertor;

// Dummy implementation so I can test my own class
public class MockingRateSupplier implements RateSupplier {

    public double getRate(String codeCode, String codeTo) {
        return 0.79;
    }
}