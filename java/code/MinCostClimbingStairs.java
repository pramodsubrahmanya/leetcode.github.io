package code;

import java.util.Arrays;

/**
 * This is a typical Dynamic Programming problem.
 * The intuition is:
 *
 * f(x) = Min{ cost(x) + f(x+1) , cost(x+1) + f(x+2) }
 *      = 0 if array length is 1;
 *
 * So keeping track of the values starting from a position
 * using the dp array as below.
 *
 * dp is initialized with length = input.length + 1 so that
 * it can keep track from the start position before the input array.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n).
 *
 */
public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int[] cost = new int[]{10, 15, 20};
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(cost));
    }

    private int minCost(int[] cost, int start, int[] dp) {
        if (start >= cost.length - 1) {
            return 0;
        }

        if (dp[start] != -1) {
            return dp[start];
        }

        int a = cost[start] + minCost(cost, start + 1, dp);
        int b = cost[start + 1] + minCost(cost, start + 2, dp);
        int val = Math.min(a, b);
        dp[start] = val;

        return val;
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp, -1);
        return minCost(cost, 0, dp);
    }


}