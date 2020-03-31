package jo.edu.htu.utils;

import java.util.*;

public class PointsEntryTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter points count: ");
        int count = scanner.nextInt();
        Set<Point> points = new HashSet<>();

        System.out.println(points.add(null));
        System.out.println(points.add(null));

        for (int current = 0; current < count; current++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Point point = new Point(x, y);
            boolean accepted = points.add(point);
            if (!accepted) {
                System.out.println("duplicate point, you still have " + (count - points.size()) + " to go");
                current--;
            }
        }

        System.out.println("accepted points are: ");
        for (Point point : points) {
            System.out.println(point);
        }

    }
}
