package jo.edu.htu.statictics;

import java.util.*;

public class StringsCollector implements StatisticsCollector<String> {


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Map<String, Integer> stringCollecter(String[] sentecnce) {
        //Iterator<Statistic> iterator=collect(Arrays.asList());
        Map<String, Integer> map = new HashMap<>();
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
        return map;
    }

    @Override
    public Iterable<Statistic> collect(Iterable<String> cases) {
        return new ArrayList<>();
    }

}
