package jo.edu.htu.currency.model;

public class DaoException extends RuntimeException {

    public DaoException() {
    }

    public DaoException(Exception e) {
        super(e);
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Exception cause) {
        super(message, cause);
    }

}
