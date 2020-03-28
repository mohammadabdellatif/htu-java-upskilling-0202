package jo.edu.htu.upskiling;

public class Calculator<OPERAND> {
    private final OperationsFactory<OPERAND> operationsFactory;

    public Calculator(OperationsFactory<OPERAND> operationsFactory) {
        this.operationsFactory = operationsFactory;
    }

    public OPERAND sum(OPERAND first, OPERAND second) {
        return null;
    }

    public OPERAND subtract(OPERAND operand1, OPERAND operand2) {
        return null;
    }

    public OPERAND multiply(OPERAND operand1, OPERAND operand2) {
        return null;
    }

    public OPERAND divide(OPERAND first, OPERAND second) {
        return null;
    }
}
