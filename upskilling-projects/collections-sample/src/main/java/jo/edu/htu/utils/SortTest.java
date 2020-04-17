package jo.edu.htu.utils;

import java.util.Arrays;
import java.util.Comparator;

public class SortTest {

    public static void main(String[] args) {
        Integer[] values = new Integer[]{10, 3, -1, -4, 8};
        sortArray(values);
        System.out.println(Arrays.toString(values));

        Point[] points = new Point[]{null, new Point(3, 4), new Point(-1, 4), new Point(-1, -4), new Point(0, 0)};
        sortArray(points);
        System.out.println(Arrays.toString(points));

        sortArray(points, (p1, p2) -> p1 == null ? 1 : -1 * p1.compareTo(p2));
        System.out.println(Arrays.toString(points));
    }

    private static <T extends Comparable> void sortArray(T[] values) {
        sortArray(values, (p1, p2) -> p1 == null ? -1 : p1.compareTo(p2));
//        sortArray(values, (p1, p2) -> p1.compareTo(p2));
    }

    private static <T> void sortArray(T[] values, Comparator<? super T> comparator) {
        for (int x = 0; x < values.length; x++) {
            for (int i = 0; i < values.length - 1; i++) {
                if (comparator.compare(values[i], values[i + 1]) > 0) {
                    swapWithNext(values, i);
                }
            }
        }
    }

    private static <T> void swapWithNext(T[] values, int i) {
        T v = values[i];
        values[i] = values[i + 1];
        values[i + 1] = v;
    }
}
