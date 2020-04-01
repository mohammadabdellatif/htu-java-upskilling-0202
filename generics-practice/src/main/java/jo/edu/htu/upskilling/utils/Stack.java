
package jo.edu.htu.upskilling.utils;

import java.util.Iterator;
public class Stack<ELEMENT> implements Iterable<ELEMENT>  {

    private int size = 0;

    private int capacity;
    private Object stackarray[];

    public Stack( int capacity ) {
        if (capacity < 0) {
            throw new IllegalArgumentException("negative size");

        }
        this.capacity = capacity;



        stackarray =  (new Object[capacity]);
    }

    public int capacity() {
        return capacity;
    }

    public int count() {
        return size;
    }

    public void push( ELEMENT e ) {
        if (size == stackarray.length) {
            throw new IllegalStateException("stack is full");

        }
        stackarray[size++] = e;
    }

    public ELEMENT pop() {
        if (size==0)
            throw new IllegalStateException("stack is empty");

        ELEMENT e = (ELEMENT) stackarray[--size];
        stackarray[size] = null;
        return e;
    }

    @Override

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stack<?> stack = (Stack<?>) o;
        if (size != stack.size) return false;
        for (int i = 0; i < size; i++)
            if (stackarray[i] != stack.stackarray[i]) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return 31 * size + 37;
    }}


 @Override
    public Iterator<ELEMENT> iterator() {
        Iterator<ELEMENT> it = new Iterator<ELEMENT>() {
            String[] arrayList=new String[capacity];

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < capacity && arrayList[currentIndex] != null;
            }

            @Override
            public ELEMENT next() {
                return (ELEMENT) arrayList[currentIndex++];
            }
        };
        return it;
    }

}

