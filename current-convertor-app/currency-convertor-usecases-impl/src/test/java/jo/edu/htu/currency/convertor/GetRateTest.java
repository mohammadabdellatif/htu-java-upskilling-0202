package jo.edu.htu.currency.convertor;

import java.io.FileNotFoundException;
import java.nio.file.Paths;

public class GetRateTest {

    public static void main(String[] args) throws FileNotFoundException {
        GetRateHandler rateHandler = new DefaultGetRateHandler(Paths.get(".", "table-i3-e.csv"));
        GetRateResult rate = rateHandler.getRate(new GetRateRequest("EUR", "JOD"));
        System.out.println(rate.getRate());
    }
}
