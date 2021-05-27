/**
 * 1871. Jump Game VII
 * Meidum
 * 滑动窗口+DP
 */
public class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) == '1') {
            return false;
        }
        boolean[] dp = new boolean[n];
        int windowSum = 1;
        dp[0] = true;
        for (int i = minJump; i < n; i++) {
            if (s.charAt(i) == '0' && windowSum > 0) {
                dp[i] = true;
            }

            if (i - maxJump >= 0 && dp[i - maxJump]) {
                windowSum--;
            }
            if (dp[i - minJump + 1]) {
                windowSum++;
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        String[] s = { "011010", "01101110", "0000000000" };
        int[] minJump = { 2, 2, 8 };
        int[] maxJump = { 3, 3, 8 };
        Solution sol = new Solution();
        for (int i = 0; i < s.length; i++) {
            System.out.println(sol.canReach(s[i], minJump[i], maxJump[i]));
        }
    }
}
