import java.util.*;

/**
 * 282. Expression Add Operators
 * Hard
 */
public class Solution {

    private List<String> ans;

    private void dfs(char[] digits, int i, long eval, String s, int target, long pre) {
        if (i == digits.length) {
            // System.out.println(s + "=" + eval);
            if (eval == target) {
                ans.add(s);
            }
            return;
        }
        int t = 0;
        for (int j = i; j < digits.length; j++) {
            if (j != i && digits[i] == '0') {
                break;
            }
            t = t * 10 + (digits[j] - '0');
            dfs(digits, j + 1, eval + t, s + "+" + t, target, t);
            dfs(digits, j + 1, eval - t, s + "-" + t, target, -t); // pre=-t
            dfs(digits, j + 1, eval - pre + pre * t, s + "*" + t, target, pre * t); // 配合pre回溯实现乘法
        }
    }

    public List<String> addOperators(String num, int target) {
        ans = new ArrayList<>();
        char[] digits = num.toCharArray();
        long t = 0;
        for (int i = 0; i < digits.length; i++) {
            if (i != 0 && digits[0] == '0') {
                break;
            }
            t = t * 10 + (digits[i] - '0');
            dfs(digits, i + 1, t, "" + t, target, t);
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] num = { "123", "232", "105", "00", "3456237490" };
        int[] target = { 6, 8, 5, 0, 9191 };
        Solution s = new Solution();
        for (int i = 0; i < target.length; i++) {
            System.out.println(s.addOperators(num[i], target[i]));
        }
    }
}