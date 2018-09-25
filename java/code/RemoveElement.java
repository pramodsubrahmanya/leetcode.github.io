package code;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        for (int j = 1; j < n; j++) {
            if (nums[j] == val) {
                nums[i] = nums[j];
                i++;
            } else {

            }
        }
        return i;
    }


}