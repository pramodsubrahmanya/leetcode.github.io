package code;

/**
 * Keep track of 3 indices and shift the indices based on maximum seen value.
 */
public class ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        Integer[] max = new Integer[3];

        for (Integer num : nums) {
            if (num.equals(max[0]) || num.equals(max[1]) || num.equals(max[2])) {
                continue;
            }
            if (max[0] == null || num >= max[0]) {
                max[2] = max[1];
                max[1] = max[0];
                max[0] = num;
            } else if (max[1] == null || num >= max[1]) {
                max[2] = max[1];
                max[1] = num;
            } else if (max[2] == null || num >= max[2]) {
                max[2] = num;
            }
        }
        if (max[2] == null) {
            return max[0];
        }
        return max[2];
    }

}