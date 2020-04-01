package jo.edu.htu.upskilling.utils;
import java.util.Iterator;
import java.util.Objects;

public class Stack<ELEMENT> implements Iterable<ELEMENT>  {
    private Object stackarry[];
    private int size;
    ELEMENT[] elements;
    int stackCapacity;

    public Stack(int capacity) {
        size = 0;
        if (capacity < 0) {
            throw new IllegalArgumentException("negative size");
        }
        stackarry = (ELEMENT[]) (new Object[capacity]);
        stackCapacity = capacity;
    }

    public int capacity() {
        return stackCapacity;
    }

    public int count() {
        return size;
    }

    public ELEMENT pop() {
        if (size == 0) {
            throw new IllegalStateException("stack is empty");
        }
        return elements[size--];
    }

    public void push(ELEMENT element) {
        if (stackCapacity == size) {
            throw new IllegalStateException("satck is full");
        }
        stackarry[size] = element;
        size = -1;
    }
    @Override
    public boolean equals(Object o) {
        Stack stack = (Stack) o;
        if (stack == null) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        return Objects.hash(stackarry);
    }

    @Override
    public Iterator<ELEMENT> iterator() {
        return null;
    }
}
