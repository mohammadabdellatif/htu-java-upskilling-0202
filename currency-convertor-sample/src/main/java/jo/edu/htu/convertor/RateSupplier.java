package jo.edu.htu.convertor;

public interface RateSupplier {
    // by default, all methods are public-abstract
    double getRate(String codeCode, String codeTo);

}
