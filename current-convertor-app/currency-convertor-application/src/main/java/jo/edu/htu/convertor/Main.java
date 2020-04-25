package jo.edu.htu.convertor;

import jo.edu.htu.currency.convertor.ConvertAmountHandler;
import jo.edu.htu.currency.convertor.DefaultConvertAmountHandler;
import jo.edu.htu.currency.convertor.BISGetRateHandler;
import jo.edu.htu.currency.convertor.GetRateHandler;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Path bisPath = Paths.get(".", "table-i3-e.csv");
        GetRateHandler rateHandler = new BISGetRateHandler(bisPath);
        ConvertAmountHandler convertAmountHandler = new DefaultConvertAmountHandler(rateHandler);
        ConsoleApp app = new ConsoleApp(rateHandler, convertAmountHandler);

        app.run();
    }
}
