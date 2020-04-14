package jo.edu.htu.n2w;

public class LengthTest {
    public static void main(String[] args) {
        NumberUtil util = new NumberUtil();
        util.length(10);
        System.out.println(NumberUtil.length(1));
        System.out.println(NumberUtil.length(535));
        System.out.println(NumberUtil.length(56_365));
        System.out.println(NumberUtil.length(234_456));
        System.out.println(NumberUtil.length(976_743));
        System.out.println(NumberUtil.length(8_976_743));
        System.out.println(NumberUtil.length(44_976_743));
        System.out.println(NumberUtil.length(54_656));
        System.out.println(Long.MAX_VALUE);



    }

    // implement number to words task
    // Introduction to Test Drive Development and unit test
    // Refactoring: Extract method, Extract variable, extract constant, inline
    // Methods reuse, recursion
    // static members (constants and methods)
    // down cast
}
