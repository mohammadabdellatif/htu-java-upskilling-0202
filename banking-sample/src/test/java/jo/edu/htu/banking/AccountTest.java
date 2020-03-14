package jo.edu.htu.banking;

import java.util.Scanner;

public class AccountTest {

    public static void main(String[] args) {
        Account account = new Account("0013456100", "Mohammad");
        account.deposit(250);
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter withdraw amount: ");
        while (true) {
            double amount = scanner.nextDouble();
            try {
                doWithdraw(account, amount);
                break;
            } catch (InsufficientBalanceException e) {
                System.out.println("insufficient balance, please insert amount:");
            } catch (WithdrawException | NegativeAmountException e) {
                System.err.println("something went wrong: " + e.getMessage());
                break;
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
