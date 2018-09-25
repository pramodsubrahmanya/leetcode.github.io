package code;

import java.util.Arrays;

public class SmallestRangeI {

    public int smallestRangeI(int[] A, int K) {
        if (A.length == 0 || A.length == 1) {
            return 0;
        }
        Arrays.sort(A);

        int diff = A[A.length - 1] - A[0];
        if (K * 2 >= diff) {
            return 0;
        } else {
            return diff - (K * 2);
        }
    }

    int findMinDiff(int[] arr) {
        Arrays.sort(arr);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] < diff) {
                diff = arr[i + 1] - arr[i];
            }
        }
        return diff;
    }

    public int smallestRangeII(int[] A, int K) {
        if (A.length == 0 || A.length == 1) {
            return 0;
        }

        int[] B = new int[A.length * 2];
        int j = 0;
        for (int i = 0; i < A.length; i++) {
            B[j] = A[i] + K;
            B[j + 1] = A[i] - K;
            j = j + 2;
        }

        return findMinDiff(B);
    }

    public int smallestRangeIII(int[] A, int K) {
        if (A.length == 0 || A.length == 1) {
            return 0;
        }

        if (A.length == 2) {
            return A[A.length - 1] - A[0] - 2 * K;
        }

        Arrays.sort(A);
        int mid = A.length / 2;

        int B[] = new int[A.length];

        for (int i = 0; i <= mid; i++) {
            B[i] = A[i] + K;
        }

        for (int i = mid + 1; i < A.length; i++) {
            B[i] = A[i] - K;
        }

        Arrays.sort(B);
        return B[B.length - 1] - B[0];
    }


    public static void main(String[] args) {
        int[] A = {0, 10};
        int K = 2;
        System.out.println(new SmallestRangeI().smallestRangeII(A, K));
    }
}