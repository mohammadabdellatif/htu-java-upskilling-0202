package jo.edu.htu.upskilling.utils;

import java.util.Arrays;
import java.util.Objects;

public class Stack<ELEMENT> {
    Object[] array;
    int pointer;
    private int size;

    public Stack(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("negative size");
        array = new Object[capacity];
        pointer=size;
    }

    public int capacity() {
        return array.length;
    }

    public int count() {
        return size;

    }

    public ELEMENT pop() {
        if (array.length == 0)
            throw new IllegalStateException("stack is empty");
        if (pointer == 0)
            throw new IllegalStateException("stack is empty");
        pointer--;
        return (ELEMENT) array[pointer];
    }

    public void push(ELEMENT element) {
        if (pointer == size)
            throw new IllegalStateException("stack is full");
        size = 1;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stack<?> stack = (Stack<?>) o;
        return size == stack.size &&
                Arrays.equals(array, stack.array);
    }

    @Override
    public int hashCode() {
        return Objects.hash(array);
    }
}

