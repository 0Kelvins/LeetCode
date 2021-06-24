/**
 * 300. Longest Increasing Subsequence
 * Medium
 * DP
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] numbers = { { 10, 9, 2, 5, 3, 7, 101, 18 }, { 0, 1, 0, 3, 2, 3 }, { 7, 7, 7, 7, 7, 7, 7 } };
        Solution s = new Solution();
        for (int[] nums : numbers) {
            System.out.println(s.lengthOfLIS(nums));
        }
    }
}
