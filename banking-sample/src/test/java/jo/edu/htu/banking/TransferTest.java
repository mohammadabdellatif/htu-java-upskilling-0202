package jo.edu.htu.banking;

import java.util.Scanner;

public class TransferTest {

    public static void main(String[] args) {
        Account debit = new Account("98765", "Mohammad");
        Account credit = new Account("12345", "Sami");
        try {
            debit.deposit(80);
        } catch (DepositException e) {
            System.out.println("unable to deposit initial amount");
            return;
        }

        TransferHandler handler = new TransferHandler();
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter amount");
        double amount = scanner.nextDouble();
        handler.transfer(debit, credit, amount);
        System.out.println("successful transaction");
        System.out.println("debit account balance: " + debit.getBalance());
        System.out.println("credit account balance: " + credit.getBalance());

    }
}
