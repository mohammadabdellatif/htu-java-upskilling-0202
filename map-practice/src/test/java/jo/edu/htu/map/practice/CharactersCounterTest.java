package jo.edu.htu.map.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class CharactersCounterTest {

    // accepts a string, returns map containing the characters and the count of its occurrences
    @Test
    public void givenAString_whenCountCharacters_thenMapContainsTheExpectedResult() {
        // given
        String sentence = "Hello, how are you";

        // when
        CharactersCounter counter = new CharactersCounter();
        Map<Character, Integer> occurrences = counter.countCharacters(sentence);

        // then
        Assertions.assertNotNull(occurrences, "should return map");
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('h', 2);
        expected.put('e', 2);
        expected.put('l', 2);
        expected.put('o', 3);
        expected.put('w', 1);
        expected.put('a', 1);
        expected.put('r', 1);
        expected.put('y', 1);
        expected.put('u', 1);

        Assertions.assertEquals(expected, occurrences, "it seems you didn't count correctly");
    }
}
