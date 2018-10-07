package code;

import java.util.Arrays;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int i = 0;
        for (i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                i = i - 1;
                break;
            }
        }

        int a = -1;

        int j = i;
        for (j = i; j < nums.length; j++) {
            if (nums[i] > nums[j]) {
                swap(nums, i, j - 1);
                break;
            }
        }

        reverse(nums, j);

    }

    void reverse(int nums[], int k) {
        int n = nums.length;
        for (int i = k; i < k + (n - k) / 2; i++) {
            swap(nums, i, n - i - 1);
        }
    }

    void swap(int[] nums, int i, int j) {
        int a = nums[i];
        nums[i] = nums[j];
        nums[j] = a;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3};
        new NextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

}