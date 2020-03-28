package jo.edu.htu.upskiling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;
import java.util.Random;

public class CalculatorTest {

    @Test
    public void givenCalculatorWithIntFactory_whenDoCalculations_thenWorkAsExpected() {
        OperationsFactory<Integer> operationsFactory = new IntegerOperationsFactory();
        Operation<Integer> summation = operationsFactory.summation();
        Operation<Integer> subtraction = operationsFactory.subtraction();
        Operation<Integer> multiplication = operationsFactory.multiplication();
        Operation<Integer> division = operationsFactory.division();

        Assertions.assertNotNull(summation, "summation implementation is null");
        Assertions.assertTrue(summation.getClass().isAnonymousClass(), "summation operation should be implemented as anonymous");

        Assertions.assertNotNull(multiplication, "multiplication implementation is null");
        Assertions.assertTrue(isLambda(multiplication.getClass()), "multiplication should be a lambda");

        Assertions.assertNotNull(division, "division implementation is null");
        Assertions.assertTrue(division.getClass().getCanonicalName().startsWith(IntegerOperationsFactory.class.getCanonicalName()), "division is not defined as inner class");

        Assertions.assertNotNull(subtraction, "subtraction implementation is null");
        Assertions.assertFalse(subtraction.getClass().isAnonymousClass(), "subtraction should be a normal class implementation the interface");

        Calculator<Integer> calculator = new Calculator<>(operationsFactory);

        int first = new Random().nextInt(20);
        int second = new Random().nextInt(20);
        Assertions.assertEquals(first + second, calculator.sum(first, second), "summation result is incorrect");
        Assertions.assertEquals(first - second, calculator.subtract(first, second), "subtraction result is incorrect");
        Assertions.assertEquals(first * second, calculator.multiply(first, second), "summation result is incorrect");
        Assertions.assertEquals(first / second, calculator.divide(first, second), "summation result is incorrect");
    }

    private static boolean isLambda(Class type) {
        return type.isSynthetic() && !type.isAnonymousClass();
    }
}
