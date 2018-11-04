package code;

/**
 * The logic here is to have two pointers first highest and second highest.
 * At the end of the loop, check if the highest pointer is >= second highest.
 * which gives the proper solution.
 */
public class LargestNumberAtLeastTwiceOfOthers {


    public int dominantIndex(int[] nums) {
        int second = Integer.MIN_VALUE;
        int highest = Integer.MIN_VALUE;

        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > highest) {
                second = highest;
                highest = nums[i];
                index = i;
            } else if (nums[i] > second) {
                second = nums[i];
            }
        }
        if (highest >= 2 * second) {
            return index;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 3, 2};
        System.out.println(new LargestNumberAtLeastTwiceOfOthers().dominantIndex(nums));
    }

}