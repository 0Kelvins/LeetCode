/**
 * 1143. Longest Common Subsequence
 * Medium
 * 动态规划还是要多用。
 */
public class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length(), upLeft, t;
        int[] dp = new int[n + 1];  // 一维滚动dp
        upLeft = 0; // dp[i-1][j-1]
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            upLeft = 0; // 字符串开始时左上角
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                t = dp[j];
                if (c1 == c2) {
                    dp[j] = upLeft + 1;
                } else {
                    dp[j] = Math.max(dp[j - 1], dp[j]);
                }
                upLeft = t;
            }    
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String[][] texts = { { "abcde", "ace" }, { "abc", "abc" }, { "abc", "def" }, { "abc", "fbc" },
                { "abc", "gggabc" }, { "ezupkr", "ubmrapg" }, { "ur", "ru" }, { "abcba", "abcbcba" }, 
                { "aaab", "aaaaa" }, {"ylqpejqbalahwr", "yrkzavgdmdgtqpg"} };
        Solution s = new Solution();
        for (String[] ts : texts) {
            System.out.println(ts[0] + "\t" + ts[1] + "\t" + s.longestCommonSubsequence(ts[0], ts[1]));
        }
    }
}