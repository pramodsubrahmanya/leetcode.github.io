package code;

public class Palindrone {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int y = x;
        int reverse = 0;
        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }
        return reverse == y;
    }

    public static void main(String[] args) {
        int x = 10;
        System.out.println(new Palindrone().isPalindrome(x));
    }
}
