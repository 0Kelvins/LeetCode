/**
 * 1035. Uncrossed Lines
 * Medium
 * 最长公共子序列变化题
 */
public class Solution {

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = nums1[i-1] == nums2[j-1] ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        int[][] nums1 = { { 1, 4, 2 }, { 2, 5, 1, 2, 5 }, { 1, 3, 7, 1, 7, 5 }, {1}, {1, 0, 1}, {1, 0, 0} };
        int[][] nums2 = { { 1, 2, 4 }, { 10, 5, 2, 1, 5, 2 }, { 1, 9, 2, 5, 1 }, {1, 0, 1}, {1}, {0, 0, 1} };
        Solution s = new Solution();
        for (int i = 0; i < nums2.length; i++) {
            System.out.println(s.maxUncrossedLines(nums1[i], nums2[i]));
        }
    }
}
