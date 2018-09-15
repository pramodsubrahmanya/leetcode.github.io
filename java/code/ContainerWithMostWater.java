package code;

/**
 * Time Complexity : O(n)
 * Space Complexity: O(1)
 * <p>
 * We use two pointers one from left and one from right.
 * Compute the area between the heights of these two pointers.
 * Move the pointer pointing to the minimum height.
 * Reperform the computation and compare with the old area and decide the max.
 *
 * The reason for this logic to work is that ,
 * The maximum area is decided by the water level with minimum height, as we cant pour water beyond that min height.
 * So taking the minimum area and computing the area from the far end will provide maximum width .
 * So the area is maximum. But in the next iteration, a higher level can contribute to max area.
 * So we move it on the right. Hence both areas pointing works.
 *
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            //Area computation
            int area = Math.min(height[left], height[right]) * (right - left);
            if (area > result) {
                result = area;
            }
            //Moving appropriate pointers.
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}