package jo.edu.htu.upskiling;

public interface OperationsFactory<T> {

    Operation<T> summation();

    Operation<T> subtraction();

    Operation<T> multiplication();

    Operation<T> division();
}
