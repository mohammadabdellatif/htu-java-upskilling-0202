package jo.edu.htu.noaa.users;

public interface AuthenticationHandler {

    void authenticate(String username, String password) throws AuthenticationException;
}
