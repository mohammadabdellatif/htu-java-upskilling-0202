package jo.edu.htu.banking;

public class Account {
    private final String number;
    private final String owner;
    private double balance;

    public Account(String number, String owner) {
        this.number = number;
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public String getNumber() {
        return number;
    }

    public String getOwner() {
        return owner;
    }

    public void deposit(double amount) throws DepositException {
        if(amount < 0)
            throw new NegativeAmountException();
        balance += amount;
    }

    public void withdraw(double amount) throws WithdrawException {
        if (amount < 0) {
            throw new NegativeAmountException();
        }
        if (balance < amount) {
            throw new InsufficientBalanceException();
        }
        balance -= amount;
    }
}
