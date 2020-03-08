package jo.edu.htu.n2w;

public class NumberUtil {

    public static int length(long number) {
        return (int) (Math.log10(number) + 1);
    }
}
