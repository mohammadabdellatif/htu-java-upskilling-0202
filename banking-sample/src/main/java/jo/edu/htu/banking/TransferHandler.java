package jo.edu.htu.banking;

public class TransferHandler {

    public void transfer(Account debitAccount, Account creditAccount, double amount)
            throws TransferException {
        if (amount < 0)
            throw new NegativeAmountException();
        try {
            debitAccount.withdraw(amount);
            creditAccount.deposit(amount);
        } catch (WithdrawFailures.WithdrawException e) {
            throw new TransferException("unable to withdraw", e);
        } catch (DepositFailures.DepositException e) {
            throw new TransferException("unable to deposit", e);
        }
    }
}
