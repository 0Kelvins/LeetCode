/**
 * 1849. Splitting a String Into Descending Consecutive Values
 * Medium
 * 不应该一开始就考虑剪枝的，应该先考虑最容易通过的方法
 */
public class Solution {

    private boolean dfs(String s, int i, long pre, int len) {
        if (pre == 0 || len == 0) {
            return false;
        }
        int start = i;
        for (int j = i; j < s.length(); j++) {
            if (s.charAt(j) != '0') {
                break;
            }
            start++;
        }
        if (pre == 1) {
            start--;
        }
        
        long next = pre - 1;
        int l = 0;
        boolean flag = true;
        String ns = String.valueOf(next);
        for (int j = start, k = 0; k < ns.length(); j++, k++) {
            if (j == s.length() || s.charAt(j) != ns.charAt(k)) {
                flag = false;
                break;
            }
            l++;
        }
        if (flag) {
            if (start + l == s.length()) {
                return true;
            }
            return dfs(s, start + l, next, l);
        }
        return false;
    }

    public boolean splitString(String s) {
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                break;
            }
            start++;
        }
        long cur = 0;
        int l = 0;
        for (int i = start; i < s.length(); i++) {
            cur = cur * 10 + (s.charAt(i) - '0');
            l++;
            if (l > (s.length() / 2 + 1)) {
                return false;
            }
            if (dfs(s, i + 1, cur, l)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] strs = {"200100", "99999999999999999998", "10", "64424509442147483647", "1234", "050043", "9080701", "10009998" };
        Solution sol = new Solution();
        for (String s : strs) {
            System.out.println(sol.splitString(s));
        }
    }
}
