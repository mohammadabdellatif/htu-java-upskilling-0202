package jo.edu.htu.utils;

import java.util.*;

public class PointsTest {

    public static void main(String[] args) {
        Collection<Point> points = new ArrayList<>();
        points.add(new Point(1, 0));
        points.add(new Point(0, 1));
        points.add(new Point(0, 0));

        Iterable<Point> iterable = points;
        Iterator<Point> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Point next = iterator.next();
        }
    }
}
