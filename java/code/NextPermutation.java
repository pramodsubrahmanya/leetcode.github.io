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

        int j = i + 1;
        if (i != 0) {
            for (j = i; j < nums.length; j++) {
                if (nums[i] > nums[j] || j == nums.length - 1) {
                    swap(nums, i, j);
                    break;
                }
            }
            reverse(nums, j);
        } else {
            reverse(nums, j-1);
        }


    }

    void reverse(int nums[], int k) {
        int n = nums.length;
        for (int i = k; i < k + (n - k) / 2; i++) {
            swap(nums, i, k + n - i - 1);
        }
    }

    void swap(int[] nums, int i, int j) {
        int a = nums[i];
        nums[i] = nums[j];
        nums[j] = a;
    }

    public static void main(String[] args) {
        //int nums[] = {1, 2, 3};
        int nums[] = {1,1,5,3};
        new NextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

}