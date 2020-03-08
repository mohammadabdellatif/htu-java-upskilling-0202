package jo.edu.htu.n2w;

public class NumberToWordConvertor {
    private static final String[] NUMBERS = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] TENS = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private static final String[] SECTION_NAME = {"", "thousand", "million", "billion", "trillion"};

    public String convert(int number) {
        return convert((long) number);
    }

    public String convert(long number) {
        if (number < 0)
            return "minus " + convert(Math.abs(number));
        if (number < 20)
            return convertLessThanTwenty((byte) number);
        if (number < 100)
            return convertTwoDigits((byte) number);
        if (number < 1_000)
            return convertThreeDigit(number);

        int length = NumberUtil.length(number);
        if (length <= SECTION_NAME.length * 3)
            return convertLargeNumber(number);
        return null;// TODO handle it differently
    }

    private String convertLargeNumber(long number) {
        String words = "";
        for (int i = SECTION_NAME.length - 1; i >= 0; i--) {
            long factor = (long) Math.pow(1000, i);
            long section = number / factor;
            number = number - (section * factor);
            if (section == 0)
                continue;
            if (!words.isEmpty())
                words += " and ";
            words += convert(section) + " " + SECTION_NAME[i];
        }
        return words;
    }

    private String convertThreeDigit(long number) {
        int hundred = (int) (number / 100);
        byte tens = (byte) (number % 100);
        String word = NUMBERS[hundred] + " hundred";
        if (tens > 0) {
            return word + " and " + convert(tens);
        }
        return word;
    }

    private String convertTwoDigits(byte number) {
        String word = TENS[number / 10];
        int ones = extractOnes(number);
        if (ones > 0)
            word += " " + convert(ones);
        return word;
    }

    private String convertLessThanTwenty(byte number) {
        return NUMBERS[number];
    }

    private int extractOnes(int number) {
        return number % 10;
    }
}
