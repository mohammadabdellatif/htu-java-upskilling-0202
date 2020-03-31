package jo.edu.htu.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionsTest {
    public static void main(String[] args) {
        List<String> values = new ArrayList<>();

        System.out.println(values.add("one"));
        System.out.println(values.add("two"));
        System.out.println(values.add("three"));
        System.out.println(values.add("four"));
        values.add("three");
        values.add("three");

        System.out.println("current size: " + values.size());

        printValues(values);
        values.remove("three");
        printValues(values);
        values.removeAll(Arrays.asList("three"));
    }

    private static void printValues(List<String> values) {
        System.out.println("=============");
        for (int i = 0; i < values.size(); i++) {
            System.out.println("element at: " + i + " is " + values.get(i));
        }
    }
}
