package jo.edu.htu.map.practice;

import java.util.Map;

public class CharactersCounter {

    // dependency
    private CountingStrategy countingStrategy;

    // dependency injection
    public CharactersCounter(CountingStrategy countingStrategy) {
        this.countingStrategy = countingStrategy;
    }

    public Map<Character, Integer> countCharacters(String sentence) {
        return this.countingStrategy.count(sentence);
    }

}
