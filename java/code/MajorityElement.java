package code;

/**
 * Logic is : Every occurence of the same element increases the count to 1
 * else if different element is found it is decreased by -1. Final value of
 * element gives the result.
 *
 * This is Boyer Moore Voter algorithm.
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int count = 0;
        int element = -1;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                element = nums[i];
            }
            count = (element == nums[i]) ? count + 1 : count - 1;
        }
        return element;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(new MajorityElement().majorityElement(nums));
    }
}