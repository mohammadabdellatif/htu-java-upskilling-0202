package jo.edu.htu.upskiling;

public class Calculator<OPERAND> {
    private final OperationsFactory<OPERAND> operationsFactory;

    public Calculator(OperationsFactory<OPERAND> operationsFactory) {
        this.operationsFactory = operationsFactory;
    }

    public OPERAND sum(OPERAND first, OPERAND second) {

        return operationsFactory.summation().execute(first, second);
    }

    public OPERAND subtract(OPERAND operand1, OPERAND operand2) {
        return operationsFactory.subtraction().execute(operand1, operand2);
    }

    public OPERAND multiply(OPERAND operand1, OPERAND operand2) {
        return operationsFactory.multiplication().execute(operand1, operand2);
    }

    public OPERAND divide(OPERAND first, OPERAND second) {
        return  operationsFactory.division().execute(first, second);
    }
}
