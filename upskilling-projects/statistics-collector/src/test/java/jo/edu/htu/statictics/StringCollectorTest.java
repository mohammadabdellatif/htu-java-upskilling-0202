package jo.edu.htu.statictics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class StringCollectorTest {

    @Test
    public void givenCollector_whenCollect_thenDataStatisticsReturnedAsExpected() {
        StatisticsCollector<String> collector = new StringsCollector();

        Iterable<String> cases = Arrays.asList(
                "Hello, ",
                "How are you today?",
                "I feel good, I got 100 score in my task",
                " but I wonder how I did make it?!");
        Iterable<Statistic> statistics = collector.collect(cases);
        Assertions.assertNotNull(statistics, "returned statistics is null");
        Map<String, Integer> asMap = new HashMap<>();
        for (Statistic statistic : statistics) {
            Assertions.assertNotNull(statistic, "one of returned statistics is null");
            String name = statistic.name();
            Integer value = statistic.matchedCases();
            Assertions.assertNotNull(name, "statistic name is null");
            Assertions.assertNotNull(value, "statistic with name " + name + " has null value");
            Assertions.assertFalse(asMap.containsKey(name), "it seems there is duplicate keys in the result: " + name);
            asMap.put(name, value);
        }

        Map<String, Integer> expectedCases = new HashMap<>();
        expectedCases.put("upper case letters", 6);
        expectedCases.put("lower case letters", 63);
        expectedCases.put("spaces count", 21);
        expectedCases.put("non-word characters", 5);

        Assertions.assertEquals(expectedCases, asMap, "the returned statistics are not as expected");
    }
}
