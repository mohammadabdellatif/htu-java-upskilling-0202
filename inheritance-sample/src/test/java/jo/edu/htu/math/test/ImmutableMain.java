package jo.edu.htu.math.test;

import jo.edu.htu.math.ImmutablePoint;

public class ImmutableMain {

    public static void main(String[] args) {
        ImmutablePoint point = new ImmutablePoint(10,4);

        System.out.println(point.getX());
        System.out.println(point.getY());

        System.out.println(point.getX());

    }
}
