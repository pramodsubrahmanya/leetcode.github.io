package code;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {

            if (!Character.isAlphabetic(s.charAt(start)) && !Character.isDigit(s.charAt(start))) {
                start++;
            } else if (!Character.isAlphabetic(s.charAt(end)) && !Character.isDigit(s.charAt(end))) {
                end--;
            } else if (!((s.charAt(start) + "").toLowerCase().equals((s.charAt(end) + "").toLowerCase()))) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "";
        System.out.println(new ValidPalindrome().isPalindrome(s));
    }

}