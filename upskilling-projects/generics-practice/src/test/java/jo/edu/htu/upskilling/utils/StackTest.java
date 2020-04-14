package jo.edu.htu.upskilling.utils;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StackTest {

    public static final Random RANDOM = new Random();

    @RepeatedTest(4)
    @Order(1)
    public void givenMinusSize_whenConstructingStack_thenFail() {
        int negativeSize = (1 + RANDOM.nextInt(10)) * -1;
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> new Stack(negativeSize));
        Assertions.assertEquals("negative size", thrown.getMessage());
    }

    @Test
    @Order(2)
    public void givenStackWithZeroSize_whenConstructingStack_thenStackIsAnEmptyStack() {
        Stack<String> stack = new Stack<>(0);
        Assertions.assertEquals(0, stack.capacity());
        assertEmptyStack(stack);
        assertFullStack(stack);
    }

    @Test
    @Order(3)
    public void givenStackWithSize_whenConstructingStack_thenPushAndPopWorkAsExpected() {
        int capacity = 3 + RANDOM.nextInt(3);
        Stack<String> stack = new Stack<>(capacity);
        String[] elements = new String[capacity];
        for (int i = 0; i < capacity; i++) {
            elements[i] = "elem-" + i;
        }

        stack.push(elements[0]);
        stack.push(elements[1]);
        stack.push(elements[2]);
        assertCountAndCapacity(stack, capacity, 3);

        String[] toPop = Arrays.copyOf(elements, 3);
        popElements(stack, toPop);
        assertCountAndCapacity(stack, capacity, 0);
        assertEmptyStack(stack);

        for (int i = 0; i < elements.length; i++) {
            int current = i;
            Assertions.assertDoesNotThrow(() -> stack.push(elements[current]), "stack has more spaces, it should not throw exception");
            assertCountAndCapacity(stack, capacity, i + 1);
        }
        assertFullStack(stack);
        popElements(stack, elements);
        assertEmptyStack(stack);
        assertCountAndCapacity(stack, capacity, 0);
    }

    @Test
    @Order(4)
    public void givenTwoStacks_whenCheckEqualsAndHashCode_thenShouldWorkAsExpected() {
        Stack<Integer> stack1 = new Stack<>(4);
        Stack<Integer> stack2 = new Stack<>(5);

        stack1.push(1);
        stack1.push(2);
        stack1.push(3);

        stack2.push(1);
        stack2.push(2);
        stack2.push(3);

        Assertions.assertTrue(stack1.equals(stack1), "equals should return true");
        Assertions.assertFalse(stack1.equals(null), "equals should return false");

        Assertions.assertTrue(stack1.equals(stack2), "equals should return true");
        Assertions.assertTrue(stack2.equals(stack1), "equals should return true");
        Assertions.assertTrue(stack1.hashCode() == stack2.hashCode(), "should have the same hashcode");

        stack1.pop();
        stack1.push(4);
        Assertions.assertFalse(stack1.equals(stack2), "equals should return false");
        Assertions.assertFalse(stack2.equals(stack1), "equals should return false");

        stack2.pop();
        Assertions.assertFalse(stack1.equals(stack2), "equals should return false");
        Assertions.assertFalse(stack2.equals(stack1), "equals should return false");
    }

    @Test
    public void givenValuesToBePushedInStack_whenPushedToStack_thenIteratorShouldIterateOverElementsInFILO() {
        Stack<String> stack = new Stack<>(5);
        stack.push("one");
        stack.push("two");
        stack.push("three");
        stack.push("four");

        Iterator<String> iterator = stack.iterator();
        Assertions.assertNotNull(iterator, "returned iterator is null");
        String[] expected = {"four", "three", "two", "one"};
        int index = 0;
        for (String value : stack) {
            Assertions.assertEquals(expected[index++], value, "iterator didn't return the expected value");
        }

    }

    private void popElements(Stack<String> stack, String[] toPop) {
        for (int i = toPop.length - 1; i >= 0; i--) {
            String pop = Assertions.assertDoesNotThrow(() -> stack.pop(), "stack has elements, it shouldn't throw exception");
            Assertions.assertEquals(toPop[i], pop, "popped element is not as expected");
        }
    }

    private void assertFullStack(Stack<String> stack) {
        IllegalStateException thrown;

        thrown = Assertions.assertThrows(IllegalStateException.class, () -> stack.push(""));
        Assertions.assertEquals("stack is full", thrown.getMessage());
    }

    private void assertEmptyStack(Stack<String> stack) {
        IllegalStateException thrown = Assertions.assertThrows(IllegalStateException.class, () -> stack.pop());
        Assertions.assertEquals("stack is empty", thrown.getMessage());
    }

    private void assertCountAndCapacity(Stack<String> stack, int capacity, int pushed) {
        Assertions.assertEquals(capacity, stack.capacity(), "the capacity should always be: " + capacity);
        Assertions.assertEquals(pushed, stack.count(), "the current count should be 3");
    }
}
