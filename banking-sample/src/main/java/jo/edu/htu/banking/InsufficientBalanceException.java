package jo.edu.htu.banking;

public class InsufficientBalanceException extends WithdrawException {

    public InsufficientBalanceException(){
        super("insufficient balance");
    }
}
