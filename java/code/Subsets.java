package code;

import java.util.ArrayList;
import java.util.List;

/**
 * Logic is to do the combinations with recursion.
 * Eg: {1,2,3}
 * It will be 1 -> {2,3} [This is the sublist after 1 , which I am keeping track using start and end index]
 * where 2 -> {3}
 * <p>
 * these individual combinations add to the final list.
 * <p>
 * <p>
 * Good Alternate Solution Reference: https://leetcode.com/problems/subsets/discuss/122645/3ms-easiest-solution-no-backtracking-no-bit-manipulation-no-dfs-no-bullshit
 */
public class Subsets {

    public List<List<Integer>> subSet(int[] nums, int start, int end) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        if (nums == null || nums.length == 0) {
            return result;
        }

        for (int i = start; i <= end; i++) {
            List<Integer> sublist = new ArrayList<>();
            sublist.add(nums[i]);
            result.add(sublist);
            List<List<Integer>> res = subSet(nums, start + 1, end);
            for (List<Integer> inner : res) {
                if (inner.size() >= 1) {
                    inner.add(0, nums[i]);
                    result.add(inner);
                }
            }
            start++;
        }
        return result;
    }

    public List<List<Integer>> subsets(int[] nums) {
        return subSet(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(new Subsets().subsets(nums));
    }
}