package jo.edu.htu.convertor;

import java.util.Scanner;

// base
public class CurrencyConvertorApp {

    // instance field (dependency)
    // I can't create a new instance
    // OOD principles applied:
    // 1- Dependency injection:
    //    a- Encapsulate what varies
    //    b- Favor composition over inheritance
    private RateSupplier rateSupplier;

    public CurrencyConvertorApp(RateSupplier rateSupplier) {
        this.rateSupplier = rateSupplier;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter from to amount:");
        // TODO I want to verify if the code inserted by user is a valid code
        // I need someone to pass him the code and returns a boolean saying if it is valid or not
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
