package code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class GBusCount {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int A[] = new int[n];
            int B[] = new int[n];
            for (int j = 0; j < n; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                A[j] = start;
                B[j] = end;
            }
            int cityCount = in.nextInt();
            int[] cities = new int[cityCount];
            for (int j = 0; j < cityCount; j++) {
                cities[j] = in.nextInt();
            }

            Map<Integer, Integer> result = new HashMap<>();
            for (int j = 0; j < A.length; j++) {
                for (int k = 0; k < cities.length; k++) {
                    if (A[j] <= cities[k] && cities[k] <= B[j]) {
                        Integer count = result.get(cities[k]);
                        if (count == null) {
                            result.put(cities[k], 0);
                        }
                        result.put(cities[k], result.get(cities[k]) + 1);
                    }
                }
            }

            StringBuilder finalResult = new StringBuilder();

            for (int k = 0; k < cities.length; k++) {
                Integer res = result.get(cities[k]);
                if (res == null) {
                    res = 0;
                }
                finalResult.append(res);
                if (k != cities.length - 1) {
                    finalResult.append(" ");
                }
            }
            System.out.println("Case #" + i + ": " + finalResult);
        }
    }

}

