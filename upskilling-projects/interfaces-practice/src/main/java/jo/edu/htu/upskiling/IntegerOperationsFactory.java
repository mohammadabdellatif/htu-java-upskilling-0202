package jo.edu.htu.upskiling;

public class IntegerOperationsFactory implements OperationsFactory<Integer> {
    // TODO you should implement this class
    @Override
    public Operation<Integer> summation() {
        Operation<Integer> operation = new Operation<Integer>() {
            @Override
            public Integer execute(Integer first, Integer second) {
                return first + second;
            }
        };
        return  operation;
    }

    @Override
    public Operation<Integer> subtraction() {
        Subtraction subtraction =new Subtraction();
        return subtraction;
    }

    @Override
    public Operation<Integer> multiplication() {
        return (first, second) -> first * second;
    }

    @Override
    public Operation<Integer> division() {
        return new Division();
    }
}

class Division implements Operation<Integer> {

    @Override
    public Integer execute(Integer first, Integer second) {
        return first / second;
    }
}
