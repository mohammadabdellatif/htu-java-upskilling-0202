package jo.edu.htu.currency.convertor;

public class BISException extends RuntimeException {

    public BISException(String message) {
        super(message);
    }

    public BISException(String message, Throwable cause) {
        super(message, cause);
    }

    public BISException(Throwable cause) {
        super(cause);
    }
}
