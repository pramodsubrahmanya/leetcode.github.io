package code;

import java.util.Arrays;

public class DistinctSubsequencesII {

    public int distinctSubseqII(String S) {
        long count = counter(S) - 1;
        System.out.println(count);
        return (int) (count % (Math.pow(10, 9) + 7));
    }

    int val = (int) Math.pow(10, 9) + 7;

    int counter(String str) {
        int[] last = new int[256];
        Arrays.fill(last, -1);
        int n = str.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = 2 * dp[i - 1];
            if (last[(int) str.charAt(i - 1)] != -1) {
                dp[i] = (dp[i] - dp[last[(int) str.charAt(i - 1)]]) % val;
            }
            last[(int) str.charAt(i - 1)] = (i - 1);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String S = "zchmliaqdgvwncfatcfivphddpzjkgyygueikthqzyeeiebczqbqhdytkoawkehkbizdmcnilcjjlpoeoqqoqpswtqdpvszfaksn";
        System.out.println(new DistinctSubsequencesII().distinctSubseqII(S));
    }


}