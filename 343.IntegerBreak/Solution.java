/**
 * 343. Integer Break
 * Medium
 * 本题使用了基本的动态规划，可以通过数学方法降低复杂度
 */
public class Solution {

    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int t, p, max = 1;
            for (int j = 2; j < i; j++) {
                t = dp[j] * (i - j);    // j的最大分割积值乘剩下值
                p = j * (i - j);        // j乘上剩下值
                t = t > p ? t : p;
                max = t > max ? t : max;
            }
            dp[i] = max;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = { 2, 10, 58, 8 };
        for (int i : nums) {
            System.out.println(s.integerBreak(i));
        }
    }
}