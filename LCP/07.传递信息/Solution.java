import java.util.Arrays;

/**
 * LCP 07. 传递信息
 * Easy
 */
public class Solution {
    public int numWays(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int[] r : relation) {
                int src = r[0], dst = r[1];
                dp[i][dst] += dp[i - 1][src];
            }
        }
        return dp[k][n - 1];
    }

    public static void main(String[] args) {
        int[] n = { 5, 3 };
        int[][][] relation = { { { 0, 2 }, { 2, 1 }, { 3, 4 }, { 2, 3 }, { 1, 4 }, { 2, 0 }, { 0, 4 } },
                { { 0, 2 }, { 2, 1 } } };
        int[] k = { 3, 2 };
        Solution s = new Solution();
        for (int i = 0; i < k.length; i++) {
            System.out.println(s.numWays(n[i], relation[i], k[i]));
        }
    }
}
// 0 0 1 0 1
// 0 0 0 0 1
// 1 1 0 1 0
// 0 0 0 0 1