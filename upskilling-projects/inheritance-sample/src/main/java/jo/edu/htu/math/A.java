package jo.edu.htu.math;

public class A {

    public void printMyType() {
        Class type = getClass();
        String message = helloMessage();
        System.out.println(message + "->" + type.getName());
    }

    String helloMessage() {
        return "Hello A,";
    }
}

class B extends A {
    @Override
    String helloMessage() {
        return "Hello B,";
    }
}

class C extends A {
    String helloMessage() {
        return "Hello C,";
    }
}