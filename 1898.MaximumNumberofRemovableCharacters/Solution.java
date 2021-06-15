import java.util.Arrays;

/**
 * 1898. Maximum Number of Removable Characters
 * Medium
 */
public class Solution {

    private boolean isSubsequence(String s, String p, int[] removable, int mid) {
        int n = s.length(), m = p.length(), j = 0;
        boolean[] ri = new boolean[n];
        for (int k = 0; k < mid; k++) {
            ri[removable[k]] = true;
        }
        for (int i = 0; i < n; i++) {
            if (!ri[i] && s.charAt(i) == p.charAt(j)) {
                j++;
                if (j == m) {
                    return true;
                }
            }
        }
        return false;
    }

    public int maximumRemovals(String s, String p, int[] removable) {
        int i = 0, j = removable.length + 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (isSubsequence(s, p, removable, mid)) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return j - 1;
    }

    public static void main(String[] args) {
        String[] s = { "abcacb", "abcbddddd", "abcab" };
        String[] p = { "ab", "abcd", "abc" };
        int[][] removable = { { 3, 1, 0 }, { 3, 2, 1, 4, 5, 6 }, { 0, 1, 2, 3, 4 } };
        Solution sol = new Solution();
        for (int i = 0; i < s.length; i++) {
            System.out.println(sol.maximumRemovals(s[i], p[i], removable[i]));
        }
    }
}
