package jo.edu.htu.convertor;

// Dummy implementation so I can test my own class
public class MockingRateSupplier implements RateSupplier {

    public double getRate(String codeCode, String codeTo) {
        return 0.79;
    }
}

class Test {

    void test()  {
        B b = new B();
        A asA = b;
        Object asObj = b;
        RateSupplier rs = b;

        Object obj = rs;
    }
}

class A {

}

class B extends A implements RateSupplier {

    public double getRate(String codeCode, String codeTo) {
        return 0;
    }
}