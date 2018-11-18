package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberOfOneBits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if (n % 2 == 1) {
                count++;
            }
            n = n / 2;
        }
        return count;
    }


    public static void main(String[] args) throws IOException {

    }
}