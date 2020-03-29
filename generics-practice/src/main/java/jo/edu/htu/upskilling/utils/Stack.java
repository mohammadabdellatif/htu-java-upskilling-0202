package jo.edu.htu.upskilling.utils;

import java.util.ArrayList;

public class Stack<ELEMENT> {
    private final int capacity;
    ArrayList<ELEMENT> stack = new ArrayList<>();

    public Stack(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("It must be positive");
        }
        stack.ensureCapacity(capacity);
        this.capacity = capacity;
    }

    public int capacity() {
        return capacity;
    }

    public int count() {
        return stack.size();
    }

    public ELEMENT pop() {
        if (count() == 0) {
            throw new IllegalArgumentException("Stack is empty");
        }
        ELEMENT pop = stack.remove(stack.size() - 1);
        return pop;
    }

    public void push(ELEMENT element) {
        if (capacity()==stack.size()){
            throw new IllegalArgumentException("Stack is full");
        }
        stack.add(element);

    }
}
