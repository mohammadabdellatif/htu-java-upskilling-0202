package jo.edu.htu.convertor;

import java.io.Serializable;
import java.util.Scanner;

// instance field (dependency)
// I can't create a new instance
// OOD principles applied:
// 1- Dependency injection:
//    a- Encapsulate what varies
//    b- Favor composition over inheritance
public class CurrencyConvertorApp {

    // dependencies
    private RateSupplier rateSupplier;
    private CodePredicate codePredicate;

    public CurrencyConvertorApp(RateSupplier rateSupplier, CodePredicate codePredicate) {
        this.rateSupplier = rateSupplier;
        this.codePredicate = codePredicate;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter from to amount:");
        String codeFrom;
        String codeTo;
        double amount;
        do {
            codeFrom = scanner.next();
            codeTo = scanner.next();
            amount = scanner.nextDouble();
        } while (!isValidCode(codeFrom, "from") | !isValidCode(codeTo, "to"));

        doConvert(codeFrom, codeTo, amount);
    }

    private boolean isValidCode(String code, String type) {
        if (!codePredicate.isValid(code)) {
            System.out.println("invalid  " + type);
            return false;
        }
        return true;
    }

    private void doConvert(String codeFrom, String codeTo, double amount) {
        double rate = rateSupplier.getRate(codeFrom, codeTo);
        double result = amount * rate;
        System.out.println("result is: " + result);
    }

}
