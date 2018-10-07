package code;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        boolean changed = false;
        boolean positive = true;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            positive = false;
        }

        if (divisor == 1) {
            return dividend;
        } else if (divisor == -1) {
            return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
        }


        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int n = dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : dividend;
        int answer = dividend == Integer.MIN_VALUE ? 1 : 0;
        while (n >= divisor) {
            n = n - divisor;
            answer++;
        }

        if (positive) {
            return answer;
        } else {
            return changed ? -answer - 1 : -answer;
        }
    }

    public static void main(String[] args) {
        int dividend = -2147483648;
        int divisor = 2;
        //System.out.println(Math.abs(dividend));
        System.out.println(new DivideTwoIntegers().divide(dividend, divisor));
    }

}