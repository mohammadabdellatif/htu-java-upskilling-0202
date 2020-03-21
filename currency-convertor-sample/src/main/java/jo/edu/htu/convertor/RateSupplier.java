package jo.edu.htu.convertor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@FunctionalInterface
public interface RateSupplier {

    double getRate(String codeFrom, String codeTo);

    default BigDecimal getRateAsBigDecimal(String codFrom, String codeTo) {
        double rate = getRate(codFrom, codeTo);
        return new BigDecimal(rate);
    }

    default BigDecimal getRateAsBigDecimal(String codFrom, String codeTo, int scale) {
        double rate = getRate(codFrom, codeTo);
        BigDecimal bigDecimal = new BigDecimal(rate);
        return bigDecimal.setScale(scale, RoundingMode.CEILING);
    }
}
