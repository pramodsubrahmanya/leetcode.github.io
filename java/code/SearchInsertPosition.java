package code;

/**
 * Logic is to hack the Binary Search using iteration.
 * At the end of the iteration if the start and end are equal,
 * then compare the element with the value of start .
 * If the target > start then start + 1 is result else
 * start is the result.
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = -1;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (start == end) { //This is the case if input array is : {3} target 3.
            if (target == nums[start]) {
                return start;
            } else if (target < nums[start]) {
                return start;
            } else {
                return start + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        //int[] nums = new int[]{1, 3, 5, 6};
        int[] nums = new int[]{1};
        int target = 2;
        System.out.println(new SearchInsertPosition().searchInsert(nums, target));
    }

}