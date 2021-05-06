import java.util.Arrays;

/**
 * 1473. Paint House III
 * Hard
 * 这题的dp细节很多，所以很难写
 */
public class Solution {

    private static final int INFINITY = Integer.MAX_VALUE / 2;

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] dp = new int[m + 1][n + 1][target + 1]; // [houses, [color, [group, [cost]]]]
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                Arrays.fill(dp[i][j], INFINITY);
            }
        }

        // previous min cost color, [min_idx, min, second_min]
        int[][][] min = new int[m + 1][target + 1][3];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= target; j++) {
                min[i][j][0] = 0;
                min[i][j][1] = min[i][j][2] = INFINITY;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (houses[i - 1] != 0 && houses[i - 1] != j) {
                    continue;
                }
                for (int k = 1; k <= target; k++) {
                    if (i == 1) {
                        if (k == 1) {
                            dp[i][j][k] = 0;
                        }
                        // else group > house, cost = INFINITY
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                        if (k > 0) {
                            int index = min[i - 1][k - 1][0], firstMin = min[i - 1][k - 1][1],
                                    secondMin = min[i - 1][k - 1][2];
                            dp[i][j][k] = Math.min(dp[i - 1][j][k], index != j ? firstMin : secondMin);
                        }
                    }
                    if (dp[i][j][k] != INFINITY && houses[i - 1] == 0) {
                        dp[i][j][k] += cost[i - 1][j - 1];
                    }
                    if (dp[i][j][k] < min[i][k][1]) {
                        min[i][k][0] = j;
                        min[i][k][2] = min[i][k][1];
                        min[i][k][1] = dp[i][j][k];
                    } else if (dp[i][j][k] < min[i][k][2]) {
                        min[i][k][2] = dp[i][j][k];
                    }
                }
            }
        }
        int ans = INFINITY;
        for (int j = 1; j <= n; ++j) {
            ans = Math.min(ans, dp[m][j][target]);
        }
        return ans != INFINITY ? ans : -1;
    }

    public static void main(String[] args) {
        int[][] houses = { { 0, 0, 0, 0, 0 }, { 0, 2, 1, 2, 0 }, { 0, 0, 0, 0, 0 }, { 3, 1, 2, 3 }, 
                { 0, 0, 0, 1 } };
        int[][][] cost = { { { 1, 10 }, { 10, 1 }, { 10, 1 }, { 1, 10 }, { 5, 1 } }, 
                { { 1, 10 }, { 10, 1 }, { 10, 1 }, { 1, 10 }, { 5, 1 } },
                { { 1, 10 }, { 10, 1 }, { 1, 10 }, { 10, 1 }, { 1, 10 } },
                { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } }, 
                { { 1, 5 }, { 4, 1 }, { 1, 3 }, { 4, 4 } } };
        int[] m = { 5, 5, 5, 4, 4 };
        int[] n = { 2, 2, 2, 3, 2 };
        int[] target = { 3, 3, 5, 3, 4 };
        Solution s = new Solution();
        for (int i = 0; i < target.length; i++) {
            System.out.println(s.minCost(houses[i], cost[i], m[i], n[i], target[i]));
        }
    }
}
