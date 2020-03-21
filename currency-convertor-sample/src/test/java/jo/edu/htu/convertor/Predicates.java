package jo.edu.htu.convertor;

public class Predicates {

    public class TruePredicate implements CodePredicate {

        public boolean isValid(String code) {
            return true;
        }
    }

    public static class FalsePredicate implements CodePredicate {

        public boolean isValid(String code) {
            return false;
        }
    }
}
