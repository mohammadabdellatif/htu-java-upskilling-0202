package jo.edu.htu.statictics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Year;

public class StudentTest {

    @Test
    public void givenBuilder_whenSetPropertiesAndBuildEmployee_thenEmployeeReturnedAsExpected() {
        Student.Builder builder = new Student.Builder();
        builder.setId("u123")
                .setName("Mohammad abdellatif")
                .setGraduationYear(Year.of(2016))
                .setUniversity("Al-Albayt")
                .setMajor("Computer information system")
                .setGender(Gender.MALE);

        Student student = builder.build();
        Assertions.assertNotNull(student, "returned employee is null");
        Assertions.assertEquals("u123", student.getId());
        Assertions.assertEquals("Mohammad abdellatif", student.getName());
        Assertions.assertEquals(Year.of(2016), student.getGraduationYear());
        Assertions.assertEquals("Al-Albayt", student.getUniversity());
        Assertions.assertEquals("Computer information system", student.getMajor());
        Assertions.assertEquals(Gender.MALE, student.getGender());
    }
}
