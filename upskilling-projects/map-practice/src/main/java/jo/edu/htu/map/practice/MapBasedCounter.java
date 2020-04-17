package jo.edu.htu.map.practice;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class MapBasedCounter implements CountingStrategy {
    @Override
    public Map<Character, Integer> count(String sentence) {
        Comparator<Character> reversed = (c1, c2) -> -1 * c1.compareTo(c2);
        Map<Character, Integer> result = new TreeMap<>(reversed);
        for (int i = 0; i < sentence.length(); i++) {
            char current = sentence.charAt(i);
            Character character = Character.toLowerCase(current);
            if (character >= 'a' && character <= 'z') {
                int count = result.getOrDefault(character, 0);
                result.put(character, count + 1);
            }
        }
        return result;
    }
}
