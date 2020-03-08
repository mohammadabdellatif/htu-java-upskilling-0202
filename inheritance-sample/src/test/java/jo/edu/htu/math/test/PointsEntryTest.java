package jo.edu.htu.math.test;

import jo.edu.htu.math.ImmutablePoint;

import java.util.Arrays;
import java.util.Scanner;

public class PointsEntryTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter points count: ");
        int count = scanner.nextInt();
        ImmutablePoint[] points = new ImmutablePoint[count];

        System.out.println(Arrays.toString(points));

        main:
        for (int current = 0; current < count; current++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            ImmutablePoint point = new ImmutablePoint(x, y);
            for (int accepted = 0; accepted < current; accepted++) {
                ImmutablePoint other = points[accepted];
                if (point.equals(other)) {
                    System.out.println("this point already exists");
                    current--;
                    continue main;
                }

            }
            points[current] = point;
        }

        System.out.println(Arrays.toString(points));

    }
}
