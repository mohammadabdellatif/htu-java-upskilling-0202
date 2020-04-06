package jo.edu.htu.statictics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class StudentsCollector implements StatisticsCollector<Student> {
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Map<String,Integer> studentCollecter(String sentecnce[]){
        Map<String,Integer> map=new HashMap<>();
        for (int i = 0; i < sentecnce[i].length(); i++) {
            char[] current = sentecnce[i].toCharArray();
            boolean character = Character.isUpperCase(i);
            int upper = 0;
            if (Character.isUpperCase(sentecnce[i].charAt(i)))
                upper++;
            int lower = 0;
            if (Character.isLowerCase(sentecnce[i].charAt(i)))
                lower++;
            System.out.println(upper + lower);
            int count = map.containsKey(character) ? map.get(character) : 0;
            map.put(character, count + 1);
        }

        }
    }
    @Override
    public Iterable<Statistic> collect(Iterable<Student> cases) {

        return new ArrayList<>();
    }
}
