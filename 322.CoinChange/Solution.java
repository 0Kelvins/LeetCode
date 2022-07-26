import java.util.Arrays;

/**
 * 322. Coin Change
 * Medium
 * 经典背包
 */
public class Solution {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int t = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                int p = i - coins[j];
                if (p >= 0 && dp[p] >= 0) {
                    t = Math.min(t, dp[p] + 1);
                }
            }
            if (t < Integer.MAX_VALUE) {
                dp[i] = t;
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[][] coins = { { 1, 2, 5 }, { 2 }, { 1 } };
        int[] amount = { 11, 3, 0 };
        Solution sol = new Solution();
        for (int i = 0; i < amount.length; i++) {
            System.out.println(sol.coinChange(coins[i], amount[i]));
        }
    }
}
