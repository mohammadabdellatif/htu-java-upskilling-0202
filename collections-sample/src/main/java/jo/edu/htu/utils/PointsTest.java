package jo.edu.htu.utils;

import java.util.*;

public class PointsTest {

    public static void main(String[] args) {
        Deque<Point> points = new LinkedList<>();
        points.add(new Point(1, 0));
        points.add(null);
        points.add(new Point(0, 1));
        points.add(new Point(0, 0));

        // peek
        System.out.println("element: " + points.element());
        System.out.println(points.poll());
        System.out.println(points.removeLast());


        System.out.println(points);

    }
}
