package code;

public class FairCandySwap {

    public int[] fairCandySwap(int[] A, int[] B) {
        long sumA = 0;
        for (int i = 0; i < A.length; i++) {
            sumA += A[i];
        }

        long sumB = 0;
        for (int i = 0; i < B.length; i++) {
            sumB += B[i];
        }

        long avg = (sumA + sumB) / 2;

        int diff = (int) (avg - sumA);
        if (diff > 0) {
            return new int[]{diff, (int) (sumB - avg)};
        } else {
            return new int[]{(int) (sumA - avg), (int) (avg - sumB)};
        }

    }

    public static void main(String[] args) {
        int[] A = {2};
        int[] B = {1, 3};
        int[] res = new FairCandySwap().fairCandySwap(A, B);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

}
