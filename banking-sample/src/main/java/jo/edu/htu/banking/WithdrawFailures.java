package jo.edu.htu.banking;

public class WithdrawFailures {

    public static class WithdrawException extends Exception {

        public WithdrawException(String message) {
            super(message);
        }
    }

    public static class InsufficientBalanceException extends WithdrawException {

        public InsufficientBalanceException() {
            super("insufficient balance");
        }
    }

    public static class LimitExceededException extends WithdrawException {

        public LimitExceededException(String message) {
            super(message);
        }
    }

}
