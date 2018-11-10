package code;

public class MaximumAverageSubarrayI {

    public double findMaxAverage(int[] nums, int k) {

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length - k - 1; i++) {
            sum = sum - nums[i - 1] + nums[i + k - 1];
            if (sum > max) {
                max = sum;
            }
        }
        return max / k;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println(new MaximumAverageSubarrayI().findMaxAverage(nums, k));
    }


}