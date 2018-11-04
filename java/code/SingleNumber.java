package code;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        return xor;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1};
        System.out.println(new SingleNumber().singleNumber(nums));
    }
}