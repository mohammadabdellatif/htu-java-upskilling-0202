package jo.edu.htu.utils;

import java.util.*;

public class PointsEntryTest2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter points count: ");
        int count = scanner.nextInt();
        List<Point> points = Collections.emptyList();
//        List<Point> points = new LinkedList<>();

        for (int current = 0; current < count; current++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Point point = new Point(x, y);
            boolean accepted = points.add(point);
            if (!accepted) {
                System.out.println("point rejected, you still have " + (count - points.size()) + " to go");
                current--;
            }
        }

        Collections.sort(points);
        System.out.println(points);
        System.out.println("enter a point to find: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        Point point = new Point(x, y);
        int index = Collections.binarySearch(points, point);
        System.out.println("index is: " + index);
    }
}
