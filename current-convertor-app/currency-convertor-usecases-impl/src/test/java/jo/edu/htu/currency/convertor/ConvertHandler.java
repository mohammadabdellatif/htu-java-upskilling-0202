package jo.edu.htu.currency.convertor;

import jo.edu.htu.currency.model.DBExchangeRateRepository;
import jo.edu.htu.currency.model.ExchangeRateRepository;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ConvertHandler {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("choose option:");
        System.out.println("1-Read from BIS file");
        System.out.println("2-Read from database");
        int option = scanner.nextInt();
        GetRateHandler rateHandler;
        switch (option) {
            case 1:
                rateHandler = getBISFileRateHandler();
                break;
            case 2:
                rateHandler = getDBRateHandler();
                break;
            default:
                System.out.println("invalid option");
                return;
        }
        ConvertAmountHandler handler = new DefaultConvertAmountHandler(rateHandler);
        ConvertResult result = handler.convert(new ConvertRequest("JOD", "CAD", BigDecimal.valueOf(230)));
        System.out.println(result.getAmount());
        System.out.println(result.getRate());
    }

    private static GetRateHandler getBISFileRateHandler() throws FileNotFoundException {
        Path path = Paths.get(".", "table-i3-e.csv");
        return new BISGetRateHandler(path);
    }

    private static GetRateHandler getDBRateHandler() {
        ExchangeRateRepository repository = new DBExchangeRateRepository();
        return new DBGetRateHandler(repository);
    }
}
