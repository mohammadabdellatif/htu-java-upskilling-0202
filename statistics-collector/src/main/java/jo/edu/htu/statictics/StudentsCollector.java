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

    public Map<String,Integer> studentCollecter(String sentecnce){
        Map<String,Integer> map=new HashMap<>();
        for (int i = 0; i <sentecnce.length() ; i++) {
            char[] current=sentecnce.toCharArray();

        }
    }
    @Override
    public Iterable<Statistic> collect(Iterable<Student> cases) {

        return new ArrayList<>();
    }
}
