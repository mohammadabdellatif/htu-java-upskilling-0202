package jo.edu.htu.convertor;

import jo.edu.htu.currency.convertor.*;

import java.math.BigDecimal;
import java.util.Scanner;

public class ConsoleApp {

    private GetRateHandler rateHandler;
    private ConvertAmountHandler convertAmountHandler;

    public ConsoleApp(GetRateHandler rateHandler,
                      ConvertAmountHandler convertAmountHandler) {
        this.rateHandler = rateHandler;
        this.convertAmountHandler = convertAmountHandler;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your option: ");
        System.out.println("1- Convert amount");
        System.out.println("2- Display rate");

        int option = scanner.nextInt();
        if (option == 1) {
            // convert amount
            handleConvertOption(scanner);
            return;
        }

        if (option == 2) {
            // display rate
            handleDisplayRateOption(scanner);
            return;
        }
        System.err.println("invalid option");
    }

    private void handleDisplayRateOption(Scanner scanner) {
        System.out.println("enter from to:");
        String from = scanner.next();
        String to = scanner.next();
        displayRate(from, to);
    }

    private void handleConvertOption(Scanner scanner) {
        System.out.println("enter from to amount: ");
        String from = scanner.next();
        String to = scanner.next();
        BigDecimal amount = scanner.nextBigDecimal();
        convertAmount(from, to, amount);
    }

    private void displayRate(String from, String to) {
        GetRateResult rate = rateHandler.getRate(new GetRateRequest(from, to));
        System.out.println("the rate is: " + rate.getRate());
    }

    private void convertAmount(String from, String to, BigDecimal amount) {
        ConvertResult result = convertAmountHandler.convert(new ConvertRequest(from, to, amount));
        System.out.println("the amount is: " + result.getAmount() + " with rate " + result.getRate());
    }
}
