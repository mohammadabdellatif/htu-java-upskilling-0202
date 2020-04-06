package jo.edu.htu.utils;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PointsEntryTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter points count: ");
        int count = scanner.nextInt();
//        Comparator<Point> comparator = (p1, p2) -> -1 * p1.compareTo(p2);
        Comparator<Point> pointComparator = (p1, p2) -> {
            if (p1.getX() == p2.getX() && p1.getY() == p2.getY())
                return 0;
            if (p1.getX() < p2.getX())
                return -1;
            if (p1.getX() > p2.getX())
                return 1;
            if (p1.getY() < p2.getY())
                return -1;
            return 1;
        };
        //Comparator<Point> reverseComparator = (p1, p2) -> -1 * pointComparator.compare(p1,p2);
        Comparator<Point> reverseComparator = pointComparator.reversed();
        Set<Point> points = new TreeSet<>(reverseComparator);

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
