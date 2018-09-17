package code;

import java.util.ArrayList;
import java.util.List;

public class SortArrayByParity {

    public int[] sortArrayByParity(int[] A) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                even.add(A[i]);
            } else {
                odd.add(A[i]);
            }
        }
        even.addAll(odd);
        return even.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] A = {3, 1, 2, 4};
        new SortArrayByParity().sortArrayByParity(A);
    }

}
