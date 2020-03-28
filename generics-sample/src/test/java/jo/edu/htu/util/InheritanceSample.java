package jo.edu.htu.util;

public class InheritanceSample {

    public static void main(String[] args) {
        IntBox intBox = new IntBox();
        intBox.put(1);
        Integer item = intBox.item();
        int v = intBox.intValue();

        Box<Integer> asBox = intBox;
        Object asObj = intBox;
    }
}
