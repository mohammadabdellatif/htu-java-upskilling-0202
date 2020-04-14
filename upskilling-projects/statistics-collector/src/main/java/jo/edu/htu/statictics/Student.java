package jo.edu.htu.statictics;

import java.time.Year;

public class Student {

    public static Builder builder() {
        return new Builder();
    }

    private Student() {

    }

    public String getId() {
        return null;
    }

    public String getName() {
        return null;
    }

    public Year getGraduationYear() {
        return null;
    }

    public String getUniversity() {
        return null;
    }

    public String getMajor() {
        return null;
    }

    public Gender getGender() {
        return null;
    }

    public static class Builder {
        public Builder setId(String id) {
            return this;
        }

        public Builder setName(String name) {
            return this;
        }

        public Builder setGraduationYear(Year graduationYear) {
            return this;
        }

        public Builder setUniversity(String university) {
            return this;
        }


        public Builder setMajor(String major) {
            return this;
        }

        public Builder setGender(Gender gender) {
            return this;
        }

        public Student build() {
            return null;
        }
    }
}
