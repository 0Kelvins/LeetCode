/**
 * 279. Perfect Squares
 * Medium
 */
public class Solution {
    public int numSquares(int n) {
        int max_sqrt = (int)Math.sqrt(n);
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= max_sqrt; i++) {
            int square = i * i;
            for (int j = square; j <= n; j++) {
                if(dp[j] == 0) {
                    dp[j] = Math.max(dp[j - square] + 1, dp[j]);
                }
                else {
                    dp[j] = Math.min(dp[j - square] + 1, dp[j]);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] n = { 12, 13 };
        Solution s = new Solution();
        for (int i : n) {
            System.out.println(s.numSquares(i));
        }
    }
}