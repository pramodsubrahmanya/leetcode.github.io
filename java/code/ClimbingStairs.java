package code;

import java.util.HashMap;
import java.util.Map;

/**
 * The logic is :
 * To climb n steps, thinking from the backward angle,
 * his previous steps could be 1 or 2.
 *
 * So f(n) = f(n -1) + f(n -2);
 *
 * using dp memoization , we can get the final solution.
 */
public class ClimbingStairs {

    Map<Integer, Integer> map = new HashMap<>();

    public int climbStairs(int n) {
        if(n <= 2) {
            return n;
        }
        if(map.get(n) == null) {
            map.put(n, climbStairs(n - 1) + climbStairs(n - 2));
        }

        return map.get(n);
    }

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(44));
    }
}