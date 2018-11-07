package code;

/**
 * Breaking condition would be to either the square is 1 or result of the square < 10.
 * For the first iteration alone if the square is < 10 do one more iteration to
 * continue further checks.
 */
public class HappyNumber {

    int getSquare(int n) {
        int res = 0;
        while (n != 0) {
            int rem = n % 10;
            res += rem * rem;
            n = n / 10;
        }
        return res;
    }

    public boolean isHappy(int n) {
        int square = getSquare(n);
        if (square != 1 && square < 10) {
            square = getSquare(square);
        }
        while (square != 1 && square >= 10) {
            square = getSquare(square);
        }
        return square == 1;
    }

    public static void main(String[] args) {
        int n = 1111111;
        System.out.println(new HappyNumber().isHappy(n));
    }

}