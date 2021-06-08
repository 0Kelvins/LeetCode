/**
 * 474. Ones and Zeroes
 * Medium
 */
public class Solution {

    private int[] getZeroOnes(String str) {
        int[] zo = new int[2];
        int len = str.length();
        for (int i = 0; i < len; i++) {
            zo[str.charAt(i) - '0']++;
        }
        return zo;
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < len; i++) {
            int[] zeroOne = getZeroOnes(strs[i]);
            int zero = zeroOne[0], one = zeroOne[1];
            for (int j = m; j >= zero; j--) {
                for (int k = n; k >= one; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zero][k - one] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String[][] strs = { { "10", "0001", "111001", "1", "0" }, { "10", "0", "1" } };
        int[] m = { 5, 1 };
        int[] n = { 3, 1 };
        Solution s = new Solution();
        for (int i = 0; i < n.length; i++) {
            System.out.println(s.findMaxForm(strs[i], m[i], n[i]));   
        }
    }
}
