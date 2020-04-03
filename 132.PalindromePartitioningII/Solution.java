/**
 * 132. Palindrome Partitioning II
 * 参考：https://leetcode-cn.com/problems/palindrome-partitioning-ii/solution/dong-tai-gui-hua-by-liweiwei1419-2/
 * 这题的解法看起来复杂度很高，但是比其递归回溯来看，反而要好点。
 */
class Solution {
    private void isPalindrome(String s, int n, int left, int right, boolean[][] palindrome) {
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right))
            palindrome[left--][right++] = true;
    }

    public int minCut(String s) {
        int n = s.length();
        if (n < 2)
            return 0;
        boolean[][] palindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            isPalindrome(s, n, i, i, palindrome);
            isPalindrome(s, n, i, i + 1, palindrome);
        }
        int[] dp = new int[n]; // i前最小分割数
        for (int i = 0; i < n; i++) // 初始化为最大分割数
            dp[i] = i;
        for (int i = 0; i < n; i++) {
            if (palindrome[0][i]) {
                dp[i] = 0;
                continue;
            }
            for (int j = 0; j < i; j++) { // 严格，确保i前有一个字符串
                if (palindrome[j + 1][i])
                    dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] in = { "aaabaa", "ababababababababababababcbabababababababababababa", "aab", "aabb", "abcbaba",
                "abcde", "a" };
        for (String i : in)
            System.out.println(s.minCut(i));
    }
}