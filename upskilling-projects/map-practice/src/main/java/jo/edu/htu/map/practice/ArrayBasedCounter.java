package jo.edu.htu.map.practice;

import java.util.HashMap;
import java.util.Map;

public class ArrayBasedCounter implements CountingStrategy {

    @Override
    public Map<Character, Integer> count(String sentence) {
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        int[] counts = new int['z' - 'a'];
        char[] chars = sentence.toCharArray();
        for (char c : chars) {
            c = Character.toLowerCase(c);
            if (c < 'a' || c > 'z')
                continue;
            counts[c - 'a']++;
        }

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 0)
                continue;
            charCountMap.put((char) (i + 'a'), counts[i]);
        }

        return charCountMap;
    }
}
