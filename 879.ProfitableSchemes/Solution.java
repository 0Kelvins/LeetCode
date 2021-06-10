import java.util.Arrays;

/**
 * 879. Profitable Schemes
 * Hard
 */
public class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int m = profit.length, MOD = (int) 1e9 + 7;
        int[][] dp = new int[n + 1][minProfit + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            int p = profit[i], g = group[i];
            for (int j = n; j >= g; j--) {
                for (int k = minProfit; k >= 0; k--) {
                    int t = k - p;
                    if (t > 0) {
                        dp[j][k] = (dp[j][k] + dp[j - g][t]) % MOD;
                    } else {
                        dp[j][k] = (dp[j][k] + dp[j - g][0]) % MOD;
                    }
                }
            }
        }
        return dp[n][minProfit];
    }

    public static void main(String[] args) {
        int[][] profit = { { 2, 3 }, { 6, 7, 8 } };
        int[][] group = { { 2, 2 }, { 2, 3, 5 } };
        int[] minProfit = { 3, 5 };
        int[] n = { 5, 10 };
        Solution s = new Solution();
        for (int i = 0; i < n.length; i++) {
            System.out.println(s.profitableSchemes(n[i], minProfit[i], group[i], profit[i]));
        }
    }
}
