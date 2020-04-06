package jo.edu.htu.statictics;

import java.util.*;

public class StringsCollector implements StatisticsCollector<String> {



    public Map<String,Integer> stringCollecter(String sentecnce){
        Iterator<Statistic> iterator=collect(Arrays.asList());
        Map<String,Integer> map=new HashMap<>();
        for (int i = 0; i <sentecnce.length() ; i++) {
        char[] current=sentecnce.toCharArray();
    }
        for (Statistic statistic : collect(Iterable<T> cases)) {

        }
return null;
        }

    @Override
    public Iterable<Statistic> collect(Iterable<String> cases) {
        return new ArrayList<>();
    }
}
