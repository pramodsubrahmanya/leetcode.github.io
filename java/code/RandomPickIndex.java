package code;

import java.util.Random;

public class RandomPickIndex {

    int[] nums;
    Random random = new Random();

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int[] count = new int[nums.length];
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count[k++] = i;
            }
        }

        return count[random.nextInt(k)];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 3};
        int target = 3;
        new RandomPickIndex(nums).pick(target);
    }
}