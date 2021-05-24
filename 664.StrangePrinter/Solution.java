import java.util.*;

/**
 * 664. Strange Printer
 * Hard
 * 这题DP挺难想的
 */
public class Solution {

    public int strangePrinter(String s) {
        int n = s.length();
        char[] sc = s.toCharArray();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (sc[i] == sc[j]) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        min = Math.min(min, dp[i][k] + dp[k + 1][j]);
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        String[] strs = { "aaabbb", "aba", "ababba", "abaaba", "ababa", "abba", "abcda", "abcba", "abac", "abacad", "abab" };
        Solution sol = new Solution();
        for (String s : strs) {
            System.out.println(s + " " + sol.strangePrinter(s));
        }
    }
}