package jo.edu.htu.upskiling;

public class Calculator<OPERAND> {
    private final OperationsFactory<OPERAND> operationsFactory;

    public Calculator(OperationsFactory<OPERAND> operationsFactory) {
        this.operationsFactory = operationsFactory;
    }

    public OPERAND sum(OPERAND first, OPERAND second) {
        Operation<OPERAND> summation = (Operation) operationsFactory.summation();
        return summation.execute(first, second);
    }

    public OPERAND subtract(OPERAND operand1, OPERAND operand2) {
        Operation<OPERAND> subtraction = (Operation) operationsFactory.subtraction();
        return subtraction.execute(operand1, operand2);
    }

    public OPERAND multiply(OPERAND operand1, OPERAND operand2) {
        Operation<OPERAND> multiplication = (Operation) operationsFactory.multiplication();
        return multiplication.execute(operand1, operand2);
    }

    public OPERAND divide(OPERAND first, OPERAND second) {
        if (second.equals(0))
            throw new IllegalArgumentException("number can not divided by 0");
        Operation<OPERAND> division = (Operation) operationsFactory.division();
        return division.execute(first, second);

    }
}
