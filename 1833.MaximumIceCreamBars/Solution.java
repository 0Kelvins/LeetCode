import java.util.Arrays;

/**
 * 1833. Maximum Ice Cream Bars
 * Medium
 */
public class Solution {

    public int maxIceCream(int[] costs, int coins) {
        int n = costs.length, ans = 0;
        Arrays.sort(costs);
        for (int i = 0; i < n; i++) {
            if (coins >= costs[i]) {
                ans++;
                coins -= costs[i];
            }
        }
        return ans;
    }

    // DP
    public int maxIceCreamDP(int[] costs, int coins) {
        int n = costs.length;
        int[] dp = new int[coins + 1];
        for (int i = 0; i < n; i++) {
            int c = costs[i];
            for (int j = coins; j >= c; j--) {
                dp[j] = Math.max(dp[j - c] + 1, dp[j]);
            }
        }
        return dp[coins];
    }

    public static void main(String[] args) {
        int[][] costs = { { 1, 3, 2, 4, 1 }, { 10, 6, 8, 7, 7, 8 }, { 1, 6, 3, 1, 2, 5 } };
        int[] coins = { 7, 5, 20 };
        Solution s = new Solution();
        for (int i = 0; i < coins.length; i++) {
            System.out.println(s.maxIceCream(costs[i], coins[i]));
        }
    }
}