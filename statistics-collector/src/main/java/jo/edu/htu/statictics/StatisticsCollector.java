package jo.edu.htu.statictics;

public interface StatisticsCollector<T> {

    Iterable<Statistic> collect(Iterable<T> cases);
}
