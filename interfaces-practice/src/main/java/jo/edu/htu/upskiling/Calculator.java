package jo.edu.htu.upskiling;

public class Calculator<OPERAND> {
    private final OperationsFactory<OPERAND> operationsFactory;

    public Calculator(OperationsFactory<OPERAND> operationsFactory) {
        this.operationsFactory = operationsFactory;
    }

    public OPERAND sum(OPERAND first, OPERAND second) {

        Operation<OPERAND> summation = operationsFactory.summation( );

        return summation.execute(first,second);
    }

    public OPERAND subtract(OPERAND operand1, OPERAND operand2) {
        Operation<OPERAND> subtract = operationsFactory.subtraction();

        return subtract.execute(operand1,operand2);
    }

    public OPERAND multiply(OPERAND operand1, OPERAND operand2) {
        Operation<OPERAND> multiply = operationsFactory.multiplication();

        return multiply.execute(operand1,operand2);

    }

    public OPERAND divide(OPERAND first, OPERAND second) {
        Operation<OPERAND> divide = operationsFactory.division();

        return divide.execute(first,second);
    }
}
