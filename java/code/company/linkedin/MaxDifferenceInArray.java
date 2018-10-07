package code.company.linkedin;

public class MaxDifferenceInArray {

    int maxDifference(int[] a) {
        if (a.length <= 1) {
            return -1;
        }
        int max = -1;
        int min = a[0];

        for (int i = 1; i < a.length; i++) {
            min = Math.min(min, a[i]);
            max = Math.max(max, a[i] - min);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {7, 9, 5, 6, 3, 2};
        System.out.println(new MaxDifferenceInArray().maxDifference(a));
    }
}
