package jo.edu.htu.convertor;

@FunctionalInterface
public interface CodePredicate {

    CodePredicate ALWAYS_TRUE = (c) -> true;
    CodePredicate ALWAYS_FALSE = c -> false;

    static CodePredicate alwaysTrue() {
        return c -> true;
    }

    static CodePredicate getAlwaysFalse() {
        return c -> false;
    }

    boolean isValid(String code);
}
