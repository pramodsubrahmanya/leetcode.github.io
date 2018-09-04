package code;

public class AtoI {

    public static void main(String[] args) {
        String str = "2147483648";
        System.out.println(new AtoI().myAtoi(str));
    }

    public int myAtoi(String str) {
        int n = str.length();
        int i = 0;
        int number = 0;
        boolean started = false;
        boolean negative = false;
        while (i < n) {
            if (str.charAt(i) == ' ' && !started) {

            } else if (Character.isDigit(str.charAt(i))) {
                int prev = number;
                number = number * 10 + (str.charAt(i) - '0');
                started = true;
                if (number / 10 != prev) {
                    if (negative) {
                        return Integer.MIN_VALUE;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }
            } else if (str.charAt(i) == '-' && !started) {
                negative = true;
                started = true;
            } else if (str.charAt(i) == '+' && !started) {
                negative = false;
                started = true;
            } else { //Character case.
                if (!started) {
                    return 0;
                } else {
                    break;
                }
            }
            i++;
        }
        if (negative) {
            return -number;
        }
        return number;
    }

}
