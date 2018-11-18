package code;

import java.util.ArrayList;

public class PowerOfThree {

    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        long x = Math.round((Math.log(n) / Math.log(3)));
        if (Math.pow(3, x) == n) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 243;
        System.out.println(new PowerOfThree().isPowerOfThree(n));
    }

}