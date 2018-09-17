import java.math.BigInteger;

public class SuperPalindrone {

    BigInteger sqrt(BigInteger n) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = n.shiftRight(5).add(BigInteger.valueOf(8));
        while (b.compareTo(a) >= 0) {
            BigInteger mid = a.add(b).shiftRight(1);
            if (mid.multiply(mid).compareTo(n) > 0) {
                b = mid.subtract(BigInteger.ONE);
            } else {
                a = mid.add(BigInteger.ONE);
            }
        }
        return a.subtract(BigInteger.ONE);
    }


    public int superpalindromesInRange(String L, String R) {
        int count = 0;
        BigInteger left = new BigInteger(L);
        BigInteger right = new BigInteger(R);
        BigInteger one = new BigInteger("1");
        for (BigInteger i = left; i.compareTo(right) <= 0; i = i.add(one)) {
            BigInteger sqrt = sqrt(i);
            if (!sqrt.multiply(sqrt).equals(i)) {
                continue;
            }
            if (isPalindrome(i) && isPalindrome(sqrt)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isPalindrome(BigInteger num) {
        String digits = num.toString();
        int numDigits = digits.length();
        if (numDigits == 1)
            return true;
        for (int i = 0; i < numDigits / 2; i++) {
            if (digits.charAt(i) != digits.charAt(numDigits - i - 1))
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        String L = "4";
        String R = "1000";

        System.out.println(new SuperPalindrone().superpalindromesInRange(L, R));
    }
}
