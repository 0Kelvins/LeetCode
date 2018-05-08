/**
 * 10. Regular Expression Matching
 * hard
 * 动态规划or递归
 * 暴力写到一半就会发现应该用递归，递归写完再想想可能就会想到DP吧。
*/
class Solution {
    // DP
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;
        
        for (int i = s.length(); i >= 0; i--){
            for (int j = p.length() - 1; j >= 0; j--){
                boolean first_match = (i < s.length() && 
                                       (p.charAt(j) == s.charAt(i) ||
                                        p.charAt(j) == '.'));
                if (j + 1 < p.length() && p.charAt(j+1) == '*') {
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                } else {
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
                // printDp(dp);
            }
        }
        return dp[0][0];
    }

    public boolean isMatchRecursion(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        boolean first_match = (!s.isEmpty() && 
                               (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));
        
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return (isMatch(s, p.substring(2)) || 
                    (first_match && isMatch(s.substring(1), p)));
        }
        else {
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }

    public void printDp(boolean[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isMatch("aa", "a"));
        System.out.println(sol.isMatch("aa", "a*"));
        System.out.println(sol.isMatch("ab", ".*"));
        System.out.println(sol.isMatch("aab", "c*a*b"));
        System.out.println(sol.isMatch("mississippi", "mis*is*p*."));
        System.out.println(sol.isMatch("abe", ".*e"));
    }
}