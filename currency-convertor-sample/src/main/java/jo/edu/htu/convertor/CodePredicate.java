package jo.edu.htu.convertor;

@FunctionalInterface
public interface CodePredicate {

    boolean isValid(String code);
}
