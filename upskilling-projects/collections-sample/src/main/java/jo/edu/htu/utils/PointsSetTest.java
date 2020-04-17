package jo.edu.htu.utils;

import java.util.Set;
import java.util.TreeSet;

public class PointsSetTest {

    public static void main(String[] args) {
        Set<Point> points = new TreeSet<>();
        points.add(new Point(1, 0));
        points.add(new Point(1, 1));
        points.add(new Point(1, -1));
        points.add(new Point(-1, 1));
        points.add(new Point(1, 1));

        for (Point point : points) {
            System.out.println(point);
        }

    }
}
