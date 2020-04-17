package jo.edu.htu.math.test;

import jo.edu.htu.math.ImmutablePoint;
import jo.edu.htu.math.ImmutablePoint3D;

public class HomeWork {

    public static void main(String[] args) {
        ImmutablePoint3D p3d3 = new ImmutablePoint3D(10, 10, 3);
        ImmutablePoint3D p3d1 = new ImmutablePoint3D(10, 10, 3);
        ImmutablePoint3D p3d2 = new ImmutablePoint3D(10, 10, 4);
        ImmutablePoint3D p3d4 = new ImmutablePoint3D(10, 11, 4);
        ImmutablePoint point = new ImmutablePoint(10, 10);

        System.out.println(p3d2.equals(p3d4));

        System.out.println("should return false: " + p3d1.equals(p3d2));
        System.out.println("should return true: " + p3d1.equals(p3d3));
        System.out.println("should be true: " + (p3d1.equals(p3d3) == p3d3.equals(p3d1)));

        System.out.println("should return false: " + point.equals(p3d1));
        System.out.println("should return false: " + p3d1.equals(point));
        System.out.println("should be true: " + (point.equals(p3d1) == p3d1.equals(point)));
    }
}
