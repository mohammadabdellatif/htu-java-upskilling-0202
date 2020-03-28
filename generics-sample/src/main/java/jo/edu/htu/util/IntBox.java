package jo.edu.htu.util;

// Static generic type (always Integer)
public class IntBox extends Box<Integer> {

    public int intValue() {
        return item();
    }
}
