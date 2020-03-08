package jo.edu.htu.math.test;

import jo.edu.htu.math.Point;
import jo.edu.htu.math.Point3D;

public class Main {

    public static void main(String[] args) {
        Point point2d = new Point();
        point2d.moveHorizontally(10);
        point2d.moveVertically(-4);
        System.out.println(point2d.getX()
                + "," + point2d.getY());

        Point3D point3D = new Point3D();
        point3D.moveHorizontally(3);
        point3D.moveVertically(-10);
        point3D.moveInDepth(4);
        System.out.println(point3D.getX()
                + "," + point3D.getY()
                + "," + point3D.getZ());


    }
}
