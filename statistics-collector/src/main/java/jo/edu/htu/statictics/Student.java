package jo.edu.htu.statictics;

import java.time.Year;
import java.util.HashSet;
import java.util.Set;

public class Student {
    private  String id="u123";
    private String name="Mohammad abdemlacif";
    private Year year;
    private String unversity="Al-Albayt";
    private String major="Computer information system";
    private Gender gender;

    public static Builder builder() {
        return new Builder();
    }

    private Student( ){


        Set<String> studentSet=new HashSet<>();
        studentSet.add("u123");
        studentSet.add("Mohammad abdemlacif");
        studentSet.add("Al-Albayt");
        studentSet.add("Computer information system");

        for (String set:studentSet) {
            System.out.println(set);
        }


    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Year getGraduationYear() {
        return year;
    }

    public String getUniversity() {
        return unversity;
    }

    public String getMajor() {
        return major;
    }

    public Gender getGender() {
        return gender;
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
    @Override
    public String toString(){
        return id+" "+name+" "+year+" "+unversity+" "+major+" "+gender;
    }
}
