package jo.edu.htu.convertor;

@FunctionalInterface
public interface RateSupplier {

    double getRate(String codeCode, String codeTo);
}
