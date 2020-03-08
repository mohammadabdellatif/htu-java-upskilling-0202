package jo.edu.htu.math.test;

import jo.edu.htu.math.ImmutablePoint;
import jo.edu.htu.math.ImmutablePoint3D;

public class ObjectMethodsTest {
    public static void main(String[] args) {
        Integer first = null;
        Integer second = 10;
        System.out.println(first + second);
    }

    public static void print(ImmutablePoint point) {
        System.out.println("point is: " + point);
    }

    public static String valueOf(Object object) {
        if (object == null)
            return "null";
        return object.toString();
    }

    public static void print(Object obj) {
        String message;
        if (obj == null)
            message = "null";
        else
            message = obj.toString();
        System.out.println(message);
    }
}
