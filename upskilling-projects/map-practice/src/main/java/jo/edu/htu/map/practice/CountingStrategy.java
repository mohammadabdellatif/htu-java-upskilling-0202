package jo.edu.htu.map.practice;

import java.util.Map;

@FunctionalInterface
public interface CountingStrategy {

    Map<Character, Integer> count(String sentence);
}