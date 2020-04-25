package jo.edu.htu.currency.convertor;

public class BISRecordUtility {
    public static final String MONTHLY_FREQUENCY_FLAG = "\"M:Monthly\"";
    public static final int FREQUENCY_INDEX = 0;

    public static boolean isMonthlyRecord(String[] fields) {
        return fields[FREQUENCY_INDEX].equals(MONTHLY_FREQUENCY_FLAG);
    }
}
