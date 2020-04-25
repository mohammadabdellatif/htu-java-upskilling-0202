package jo.edu.htu.currency.convertor;

public class ImportException extends RuntimeException {
    public ImportException(Exception e) {
        super(e);
    }
}
