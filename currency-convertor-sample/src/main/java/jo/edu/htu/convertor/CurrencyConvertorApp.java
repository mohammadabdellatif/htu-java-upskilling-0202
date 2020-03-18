package jo.edu.htu.convertor;

import java.util.Scanner;

// base
public class CurrencyConvertorApp {

    // instance field (dependency)
    // I can't create a new instance
    private RateSupplier rateSupplier;

    // If you want to construct this app, you need to pass a rate supplier
    public CurrencyConvertorApp(RateSupplier rateSupplier) {
        this.rateSupplier = rateSupplier;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter from to amount:");
        String codeFrom = scanner.next();
        String codeTo = scanner.next();
        double amount = scanner.nextDouble();
        double rate = getRate(codeFrom, codeTo); // unknown
        double result = amount * rate;
        System.out.println("result is: " + result);
    }

    protected double getRate(String codeFrom, String codeTo) {
        // I need another component to fetch rate
        // my responsibility is to convert
        // responsibility of finding the correct rate is not mine
        double rate = rateSupplier.getRate(codeFrom, codeFrom);
        return rate;
    }
}
