import java.util.*;

/**
 * 131. Palindrome Partitioning
 * 这题的递归回溯是有点难的。
 */
class Solution {
    private boolean isPalindrome(String s, int len, int i, int j, boolean[][] palindrome) {
        while (i >= 0 && j < len && s.charAt(i) == s.charAt(j)) {
            palindrome[i][j] = true;
            i--;
            j++;
        }
        return true;
    }

    /**
     * @param t 路径，已处理的start前的回文串
     * @param start 待处理s的剩余字符下标
     */
    private void part(List<List<String>> result, List<String> t, String s, boolean[][] palindrome, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(t));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (palindrome[start][i]) {
                t.add(s.substring(start, i + 1));
                part(result, t, s, palindrome, i + 1);
                t.remove(t.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if ("".equals(s))
            return result;
        int len = s.length();
        boolean[][] palindrome = new boolean[len][len]; // 预处理对应位置字符串是否为回文串
        for (int i = 0; i < len; i++) {
            isPalindrome(s, len, i, i, palindrome); //奇数回文串
            isPalindrome(s, len, i, i + 1, palindrome); // 偶数回文串
        }
        List<String> t = new ArrayList<>();
        part(result, t, s, palindrome, 0);
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] ss = { "aab", "aabb", "amanaplanacanalpanama" };
        for (String s : ss) {
            List<List<String>> result = solution.partition(s);
            for (List<String> r : result) {
                for (String i : r)
                    System.out.print(i + " ");
                System.out.println();
            }
            System.out.println();
        }
    }
}