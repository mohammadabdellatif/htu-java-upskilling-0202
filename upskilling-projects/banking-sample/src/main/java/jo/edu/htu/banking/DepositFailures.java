package jo.edu.htu.banking;

public class DepositFailures {

    public static class DepositException extends Exception {
        public DepositException(String message) {
            super(message);
        }

        public DepositException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
