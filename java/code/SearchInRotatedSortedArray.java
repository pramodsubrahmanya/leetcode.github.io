package code;

public class SearchInRotatedSortedArray {

    public int binarySearch(int[] nums, int target, int start, int end) {
        if (nums.length == 0 || start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        }

        if (nums[start] <= nums[mid]) {
            if (nums[start] <= target && target <= nums[mid]) {
                return binarySearch(nums, target, start, mid - 1);
            }
            return binarySearch(nums, target, mid + 1, end);
        } else {
            if (nums[mid] <= target && target <= nums[end]) {
                return binarySearch(nums, target, mid + 1, end);
            }
            return binarySearch(nums, target, start, mid - 1);
        }
    }

    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public static void main(String[] args) {
//        int[] nums = {1, 3};
        int[] nums = {4, 5, 6, 7, 8, 1, 2, 3};
        int target = 2;
        System.out.println(new SearchInRotatedSortedArray().search(nums, target));
    }

}