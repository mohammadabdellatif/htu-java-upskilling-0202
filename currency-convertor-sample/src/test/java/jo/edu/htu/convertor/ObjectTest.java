package jo.edu.htu.convertor;

import jo.edu.htu.math.Shape;

import java.io.Serializable;

public class ObjectTest {

    public static void main(String[] args) {
        Object obj1 = new Dummy();
        System.out.println(obj1);

        // anonymous (unknown name), inline usage
        Object obj2 = new Object() {
            public String toString() {
                return "dummy_2";
            }
        };
        System.out.println(obj2);

        Shape shape = new Shape() {
            public double area() {
                return 10;
            }
            public double circumference() {
                return 110;
            }
        };
        System.out.println(shape.area());
        System.out.println(shape.circumference());

        AppTest test = new AppTest(40) {

        };
    }

    public static class Dummy extends Object {
        @Override
        public String toString() {
            return "dummy";
        }
    }
}
