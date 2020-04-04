package jo.edu.htu.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {

    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        set.add("Basel");
        set.add("Zaineb");
        System.out.println(set.add("Ahmad"));
        System.out.println(set.add("Ahmad"));

        for (String value : set) {
            System.out.println(value);
        }

        String a1 = "A";
        String b = "B";
        String a2 = "A";

        System.out.println("should return 0:" + a1.compareTo(a2));
        System.out.println("should return -1:" + a1.compareTo(b));
        System.out.println("should return 1: " + b.compareTo(a1));
    }
}
