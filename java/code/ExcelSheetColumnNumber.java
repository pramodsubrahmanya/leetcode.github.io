package code;

public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        int result = 0;
        int mult = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            int val = ch - 64;
            result += val * mult;
            mult *= 26;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "AZY";
        System.out.println(new ExcelSheetColumnNumber().titleToNumber(s));
    }

}