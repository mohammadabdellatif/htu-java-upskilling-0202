package jo.edu.htu.banking;

import java.util.Scanner;

public class AccountTest {

    public static void main(String[] args) {
        Account account = new Account("0013456100", "Mohammad");
        try {
            account.deposit(250);
        } catch (DepositException e) {
            System.err.println("unable to deposit initial amount: " + e.getMessage());
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter withdraw amount: ");
        while (true) {
            try {
                double amount = scanner.nextDouble();
                doWithdraw(account, amount);
                break;
            }  catch (WithdrawException e) {
                System.err.println("something went wrong: " + e.getMessage());
                System.out.println("try again");
            }
        }
        System.out.println(account.getBalance());
    }

    private static void doWithdraw(Account account, double amount) throws WithdrawException {
        System.out.println("try to withdraw");
        account.withdraw(amount);
        System.out.println("withdraw success");

    }
}
