package code;

public class FindTheDifference {

    public char findTheDifference(String s, String t) {
        char xor = 0;
        for (int i = 0; i < s.length(); i++) {
            xor ^= s.charAt(i);
        }

        for (int i = 0; i < t.length(); i++) {
            xor ^= t.charAt(i);
        }
        return xor;
    }

    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        System.out.println(new FindTheDifference().findTheDifference(s, t));
    }

}