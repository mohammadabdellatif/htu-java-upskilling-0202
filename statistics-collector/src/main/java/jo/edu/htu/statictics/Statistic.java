package jo.edu.htu.statictics;

public interface Statistic extends Comparable<Statistic> {

    String name();

    Integer matchedCases();
}
