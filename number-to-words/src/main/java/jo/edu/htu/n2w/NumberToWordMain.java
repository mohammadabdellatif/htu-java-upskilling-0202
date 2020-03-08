package jo.edu.htu.n2w;

public class NumberToWordMain {

    // TDD = Test Driven Development
    public static void main(String[] args) {
        NumberToWordConvertor convertor = new NumberToWordConvertor();

        System.out.println(convertor.convert(8));
        System.out.println(convertor.convert(10));
        System.out.println(convertor.convert(19));
        System.out.println(convertor.convert(15));
        System.out.println(convertor.convert(20));
        System.out.println(convertor.convert(30));
        System.out.println(convertor.convert(60));
        System.out.println(convertor.convert(99));
        System.out.println(convertor.convert(23));
        System.out.println(convertor.convert(200));
        System.out.println(convertor.convert(585));
        System.out.println(convertor.convert(119));
        System.out.println(convertor.convert(365));
        System.out.println(convertor.convert(9_999));
        System.out.println(convertor.convert(8_765));
        System.out.println(convertor.convert(1_435));
        System.out.println(convertor.convert(1_000));
        System.out.println(convertor.convert(1_000_000));
        System.out.println(convertor.convert(6_879_009));
        System.out.println(convertor.convert(Long.MAX_VALUE));
        System.out.println(convertor.convert(-100));
        System.out.println(convertor.convert(-100_999_112));

    }
}

