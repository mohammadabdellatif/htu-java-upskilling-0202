package jo.edu.htu.currency.convertor;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConvertHandler {

    public static void main(String[] args) throws FileNotFoundException {
        Path path = Paths.get(".", "table-i3-e.csv");
        GetRateHandler rateHandler = new DefaultGetRateHandler(path);

        ConvertAmountHandler handler = new DefaultConvertAmountHandler(rateHandler);
        ConvertResult result = handler.convert(new ConvertRequest("JOD", "CAD", BigDecimal.valueOf(230)));
        System.out.println(result.getAmount());
        System.out.println(result.getRate());
    }
}
