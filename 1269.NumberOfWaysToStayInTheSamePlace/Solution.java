import java.util.Arrays;

/**
 * 1269. Number of Ways to Stay in the Same Place After Some Steps
 * Hard
 */
public class Solution {

    public int numWays(int steps, int arrLen) {
        int mod = (int) 1e9 + 7;
        int maxDistance = Math.min(steps / 2 + 1, arrLen);
        int[] dp = new int[maxDistance];
        dp[0] = 1;
        for (int i = 1; i <= steps; i++) {
            int[] next = new int[maxDistance];
            for (int j = 0; j < maxDistance; j++) {
                next[j] = dp[j];
                if (j > 0) {
                    next[j] = (next[j] + dp[j - 1]) % mod;
                }
                if (j + 1 < maxDistance) {
                    next[j] = (next[j] + dp[j + 1]) % mod;
                }
            }
            dp = next;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int steps = 8, arrLen = 8;
        Solution s = new Solution();
        for (int i = 1; i < arrLen; i++) {
            for (int j = 1; j < steps; j++) {
                System.out.print(s.numWays(j, i) + "\t");
            }
            System.out.println();
        }
    }
}