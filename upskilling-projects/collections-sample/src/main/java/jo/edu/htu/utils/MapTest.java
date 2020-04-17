package jo.edu.htu.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
        Map<Integer, String> numbers = new HashMap<>();

        System.out.println(numbers.put(1, "One"));
        System.out.println(numbers.put(2, "Two"));
        System.out.println(numbers.put(3, "Three"));

        System.out.println(numbers);

        System.out.println(numbers.put(1, "ONE"));
        System.out.println(numbers.put(2, "ONE"));

        System.out.println(numbers);

        System.out.println(numbers.containsKey(1));
        System.out.println(numbers.containsKey(5));

        numbers.remove(3);
        numbers.remove(6);
        numbers.remove("dhfkaljfldsa");

        System.out.println("size: " + numbers.size());
        Set<Integer> keys = numbers.keySet();
        for (Integer key : keys) {
            String value = numbers.get(key);
            System.out.println(key + "->" + value);
        }
    }
}
