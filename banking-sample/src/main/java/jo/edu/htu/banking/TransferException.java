package jo.edu.htu.banking;

public class TransferException extends RuntimeException {

    public TransferException(String message) {
        super(message);
    }

    public TransferException(Exception cause) {
        super(cause);
    }

    public TransferException(String message, Exception cause) {
        super(message, cause);
    }
}
