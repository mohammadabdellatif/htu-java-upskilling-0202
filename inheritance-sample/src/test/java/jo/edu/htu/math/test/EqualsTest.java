package jo.edu.htu.math.test;

import jo.edu.htu.math.ImmutablePoint;

import java.util.Arrays;

public class EqualsTest {

    public static void main(String[] args) {
        ImmutablePoint p1 = new ImmutablePoint(3, 4);
        ImmutablePoint p2 = new ImmutablePoint(4, 3);
        ImmutablePoint p3 = new ImmutablePoint(4, 3);
        ImmutablePoint p4 = null;
        int[] values = new int[10];
        Object obj = values;

        if(obj instanceof int[]) {
            System.out.println(Arrays.toString(values));
        }

        System.out.println("should return false: " + p1.equals(values));
        System.out.println("should return false: " + p1.equals(p4));
        System.out.println("should return true: " + p2.equals(p3));
        System.out.println("should return true: " + p3.equals(p2));
        //System.out.println(p4.equals(null));// always throw NullPointerException

    }
}
