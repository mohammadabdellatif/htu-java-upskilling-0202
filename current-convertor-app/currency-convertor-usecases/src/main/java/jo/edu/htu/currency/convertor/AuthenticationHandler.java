package jo.edu.htu.currency.convertor;

public interface AuthenticationHandler {

    void authenticate(String username, String password) throws AuthenticationException;
}
