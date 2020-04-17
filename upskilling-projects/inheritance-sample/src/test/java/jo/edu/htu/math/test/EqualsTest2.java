package jo.edu.htu.math.test;

import jo.edu.htu.math.ImmutablePoint;

public class EqualsTest2 {

    public static void main(String[] args) {
        ImmutablePoint p1 = new ImmutablePoint(5, 4);
        ImmutablePoint p2 = new ImmutablePoint(4, 3);
        ImmutablePoint p3 = p2;
        Integer x = 10;
        Integer y = new Integer(10);

        System.out.println(x == y);
        System.out.println(x.equals(y));

        System.out.println("should be true: " + p2.equals(p3));
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p3.hashCode());
        System.out.println("should be true: " + (p2.hashCode() == p3.hashCode()));
    }
}
