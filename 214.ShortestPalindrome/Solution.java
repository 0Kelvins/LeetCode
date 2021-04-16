import java.util.Arrays;

/**
 * 214. Shortest Palindrome
 * Hard
 * 设输入字符串为s(abaa)，逆序s为s'(aaba),(aba)为s最长回文子串，亦是s'的最长回文子串，
 * 以s为模式串在s'中进行模式匹配，找出回文边界后即可对剩余字符进行补全
 */
public class Solution {

    // 暴力，超时
    public String shortestPalindrome(String s) {
        int n = s.length(), i, j, max = 0;
        for (i = n - 1; i >= 0; i--) {
            for (j = 0; j < n; j++) {
                if (s.charAt(j) != s.charAt(i - j)) {
                    break;
                }
                if (i - j == 0) {
                    break;
                }
            }
            if (j - i == 0) {
                max = j;
                break;
            }
        }
        String add = (max == n - 1) ? "" : s.substring(max + 1);
        StringBuilder builder = new StringBuilder(add).reverse();
        builder.append(s);
        return builder.toString();
    }

    // KMP
    public String shortestPalindromeKmp(String s) {
        int n = s.length();
        char[] sc = s.toCharArray();
        int[] next = new int[n];    // 匹配失败跳转位置
        Arrays.fill(next, -1);
        for (int i = 1; i < n; i++) {
            int j = next[i - 1];
            while (j != -1 && sc[j + 1] != sc[i]) {
                j = next[j];
            }
            if (sc[j + 1] == sc[i]) {
                next[i] = j + 1;
            }
        }
        int bound = -1; // s中最长回文的边界
        for (int i = n - 1; i >= 0; i--) {  // 对逆序串匹配最长回文
            while (bound != -1 && sc[bound + 1] != sc[i]) {
                bound = next[bound];
            }
            if (sc[bound + 1] == sc[i]) {
                bound++;
            }
        }
        String add = (bound == n - 1) ? "" : s.substring(bound + 1);
        StringBuilder builder = new StringBuilder(add).reverse();
        builder.append(s);
        return builder.toString();
    }

    public static void main(String[] args) {
        String[] strs = { "aacecaaa", "abcd", "bacecaaa", "a", "aa", "bbaaaa", "ba", "aabba" };
        Solution sol = new Solution();
        for (String s : strs) {
            System.out.println(sol.shortestPalindrome(s));
        }
    }
}