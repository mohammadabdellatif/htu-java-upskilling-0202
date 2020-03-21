package jo.edu.htu.convertor;

public class MockingCodePredicate implements CodePredicate {
    @Override
    public boolean isValid(String code) {
        switch (code) {
            case "JOD":
            case "USD":
            case "JPY":
            case "SAR":
            case "EURO":
                return true;
        }
        return false;
    }
}
