package jo.edu.htu.upskilling.utils;

public class Stack<ELEMENT> {
    int capacity;
    public Stack(int capacity) {
        this.capacity=capacity;
    }

    public int capacity()  {
        if (capacity<0)
    throw new IllegalArgumentException("negative size");
        if (capacity==0)
            pop();
        return 0;
    }

    public int count() {
        return -1;
    }

    public ELEMENT pop() {
        if (capacity==0)
            throw new IllegalStateException("stack is empty");
        return null;
    }

    public void push(ELEMENT element) {

    }
}
