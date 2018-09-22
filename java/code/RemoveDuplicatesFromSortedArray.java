package code;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    /**
     * TimeComplexity: O(n)
     * SpaceComplexity: O(2)
     * Logic is:
     * 1. Compare last seen value with the next value in the array.
     * If the two values are same , then skip the next value.
     * If the two values are different, then copy the new value into current location
     * and proceed forward.
     *
     * @author Pramod (@pramodnanduri)
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0 || n == 1) {
            return n;
        }
        int i = 1;
        int j = i;
        int last = nums[i - 1]; //Starting with the second pointer to avoid edge cases.
        while (i < n && j < n) {
            if (last == nums[j]) { //Comparing last seen.
                j++;
            } else {
                last = nums[j];
                nums[i] = last;
                i++;
                j++;
            }
        }
        return i; //i tracks the current location and hence the end of the array.
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}