package jo.edu.htu.statictics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Year;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StudentCollectorTest {

    @Test
    public void givenCollector_whenCollect_thenDataStatisticsReturnedAsExpected() {
        StatisticsCollector<Student> collector = new StudentsCollector();

        Iterable<Student> cases = Arrays.asList(
                Student.builder()
                        .setName("Sara")
                        .setGender(Gender.FEMALE)
                        .setGraduationYear(Year.of(2019))
                        .setMajor("Computer Science")
                        .setUniversity("HU")
                        .build(),
                Student.builder()
                        .setName("Sara")
                        .setGender(Gender.FEMALE)
                        .setGraduationYear(Year.of(2018))
                        .setMajor("CIS")
                        .setUniversity("HU")
                        .build(),
                Student.builder()
                        .setName("Sara")
                        .setGender(Gender.FEMALE)
                        .setGraduationYear(Year.of(2017))
                        .setMajor("CIS")
                        .setUniversity("HU")
                        .build(),
                Student.builder()
                        .setName("Hani")
                        .setGender(Gender.MALE)
                        .setGraduationYear(Year.of(2012))
                        .setMajor("Computer Science")
                        .setUniversity("HU")
                        .build(),
                Student.builder()
                        .setName("Sabri")
                        .setGender(Gender.MALE)
                        .setGraduationYear(Year.of(2016))
                        .setMajor("CIS")
                        .setUniversity("HU")
                        .build());

        Iterable<Statistic> statistics = collector.collect(cases);
        Assertions.assertNotNull(statistics, "returned statistics is null");
        Map<String, Integer> asMap = new HashMap<>();
        for (Statistic statistic : statistics) {
            Assertions.assertNotNull(statistic, "one of returned statistics is null");
            String name = statistic.name();
            Integer value = statistic.matchedCases();
            Assertions.assertNotNull(name, "statistic name is null");
            Assertions.assertNotNull(value, "statistic with name " + name + " has null value");
            asMap.put(name, value);
        }

        Map<String, Integer> expectedCases = new HashMap<>();
        expectedCases.put("CIS major", 3);
        expectedCases.put("Computer Science major", 2);
        expectedCases.put("graduation year <= 2016", 2);
        expectedCases.put("graduation year > 2016", 3);
        expectedCases.put("Males", 2);
        expectedCases.put("Females", 3);

        Assertions.assertEquals(expectedCases, asMap, "the returned statistics are not as expected");
    }
}
