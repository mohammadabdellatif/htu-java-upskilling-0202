package jo.edu.htu.map.practice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// TODO reimplement this sample in a cleaner way
public class CharactersCounter {

    public Map<Character, Integer> countCharacters(String sentence) {
        Comparator<Character> reversed = (c1, c2) -> -1 * c1.compareTo(c2);
        Map<Character, Integer> result = new TreeMap<>(reversed);
        for (int i = 0; i < sentence.length(); i++) {
            char current = sentence.charAt(i);
            Character character = Character.toLowerCase(current);
            if (character >= 'a' && character <= 'z') {
                //int count = result.containsKey(character) ? result.get(character) : 0;
                int count = result.getOrDefault(character, 0);
                result.put(character, count + 1);
            }
        }
        return result;
    }

//    public Map<Character, Integer> countCharacters(String sentence) {
//        HashMap<Character, Integer> charCountMap = new HashMap<>();
//        int[] counts = new int['z' - 'a'];
//        char[] chars = sentence.toCharArray();
//        for (char c : chars) {
//            c = Character.toLowerCase(c);
//            if (c < 'a' || c > 'z')
//                continue;
//            counts[c - 'a']++;
//        }
//
//        for (int i = 0; i < counts.length; i++) {
//            if (counts[i] == 0)
//                continue;
//            charCountMap.put((char) (i + 'a'), counts[i]);
//        }
//
//        return charCountMap;
//    }

//    public Map<Character, Integer> countCharacters(String sentence) {
//        HashMap<Character, Integer> charCountMap = new HashMap<>();
//
//        char[] strArray = sentence.toCharArray();
//        for (char c : strArray) {
//            c = Character.toLowerCase(c);
//            if (c < 'a' || c > 'z')
//                continue;
//
//            if (charCountMap.containsKey(c)) {
//                charCountMap.put(c, charCountMap.get(c) + 1);
//            } else {
//                charCountMap.put(c, 1);
//            }
//        }
//        return charCountMap;
//    }



    /*public Map<Character, Integer> countCharacters(String sentence) {
        Map<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < sentence.length(); i++) {
            char current = sentence.charAt(i);
            Character character = Character.toLowerCase(current);
            if (character >= 'a' && character <= 'z') {
                int count = result.containsKey(character) ? result.get(character) : 0;
                result.put(character, count + 1);
            }
        }
        return result;
    }*/
}
