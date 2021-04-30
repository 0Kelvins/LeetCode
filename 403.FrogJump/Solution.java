import java.util.*;

/**
 * 403. Frog Jump
 * Hard
 * 自己用HashMap做的bfs性能太差，可能剪枝提前返回会好些
 */
public class Solution {

    public boolean canCross(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        for (int i = 1; i < n; i++) {   // 由于距离累积最多+1变化，两块石头间距离不会大于当前i
            if (stones[i] - stones[i - 1] > i) {
                return false;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int g = stones[i] - stones[j];
                if (g > j + 1) {    // 同上
                    break;
                }
                dp[i][g] = dp[j][g - 1] || dp[j][g] || dp[j][g + 1];
                if (i == n - 1 && dp[i][g]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] stones = { { 0, 1, 3, 5, 6, 8, 12, 17 }, { 0, 1, 2, 3, 4, 8, 9, 11 }, { 0, 1, 3, 6, 7 },
                { 0, 1, 3, 6, 9, 10 }, {0, 1, 3, 6, 7, 8}, {0, 2} };
        for (int i = 0; i < stones.length; i++) {
            System.out.println(s.canCross(stones[i]));
        }
    }
}
