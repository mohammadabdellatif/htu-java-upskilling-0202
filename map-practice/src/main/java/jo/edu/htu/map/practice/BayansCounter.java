package jo.edu.htu.map.practice;

import java.util.HashMap;
import java.util.Map;

public class BayansCounter implements CountingStrategy {
    @Override
    public Map<Character, Integer> count(String sentence) {
        HashMap<Character, Integer> charCountMap = new HashMap<>();

        char[] strArray = sentence.toCharArray();
        for (char c : strArray) {
            c = Character.toLowerCase(c);
            if (c < 'a' || c > 'z')
                continue;

            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }
        return charCountMap;
    }
}
