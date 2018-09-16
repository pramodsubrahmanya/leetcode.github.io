package code;

import java.util.Arrays;

/**
 * TimeComplexity: O(n^2 * log(n))
 * Logic:
 * 1. First of all we sort the input.
 * 2. This problem works on the concept of
 * if a[i] + a[j] + a[k] needs to be near to target, it can be rewritten as
 * target - (a[i] + a[j]) gives the element which needs to be present in the original array.
 * So to find the nearest element in the array, we hack the concept of Binary search
 * During the Binary search recursion call, if the element is closer to the element,
 * then that element is returned as the result insted of not found .
 * <p>
 * So iterating each element and performining binary search results in the solution.
 */
public class ThreeSumClosest {

    /**
     * Hack of Binary search to find the nearest target.
     */
    public int nearest(int arr[], int start, int end, int target) {
        if (start >= arr.length) {
            return Integer.MAX_VALUE;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            return target;
        }

        if (start == mid || end == mid) {
            //Hacking binary search to find the nearest.
            if ((target - arr[start]) >= (arr[end] - target)) {
                return arr[end];
            } else {
                return arr[start];
            }
        }
        if (arr[mid] < target) {
            //While skipping mid part, if the mid element difference of target is less than
            //the mid+1 element that means it is the minimum.
            if (target - arr[mid] < arr[mid + 1] - target) {
                return arr[mid];
            }
            return nearest(arr, mid + 1, end, target);
        } else {
            return nearest(arr, start, mid, target);
        }
    }

    public int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int resSum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                //Core logic
                int nearToTarget = target - (nums[i] + nums[j]);
                int nearest = nearest(nums, j + 1, nums.length - 1, nearToTarget);
                //Logic with edge cases.
                if (nearest != Integer.MAX_VALUE && Math.abs(nearToTarget - nearest) < Math.abs(result)) {
                    result = nearToTarget - nearest;
                    resSum = nums[i] + nums[j] + nearest;
                }
            }
        }
        return resSum;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 1, -1};
        int[] nums = {1, 2, 4, 8, 16, 32, 64, 128};
        int target = 82;

//        int[] nums = {-55, -24, -18, -11, -7, -3, 4, 5, 6, 9, 11, 23, 33};
//        int target = 0;
        System.out.println(new ThreeSumClosest().threeSumClosest(nums, target));
    }
}

