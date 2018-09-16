package code;

import java.util.*;

/**
 * Core concept here is
 * 1. Sort the elements.
 * 2. Skip duplicate numbers using i, j skip if the element is not there in the map.
 * Duplicate elements in the result are skipped by skipping the
 * i pointer.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        //Map for easy check.
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = -(nums[i] + nums[j]);
                //Check if sum is present in map.
                //For cases like : input = {2,-4} this second condition is used.
                if (map.containsKey(sum) && map.get(sum) > j) {
                    j = map.get(nums[j]);
                    result.add(Arrays.asList(nums[i], nums[j], sum));
                }
            }
            i = map.get(nums[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-55, -24, -18, -11, -7, -3, 4, 5, 6, 9, 11, 23, 33};
        System.out.println(new ThreeSum().threeSum(nums));
    }
}