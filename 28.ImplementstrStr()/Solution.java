/**
 * 28. Implement strStr()
 * Easy
 * KMP复习
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        char[] hc = haystack.toCharArray(), nc = needle.toCharArray();
        if(m == 0) {
            return 0;
        }
        int[] next = new int[m];
        int j = 0;
        for (int i = 1; i < m; i++) {
            while (j > 0 && nc[i] != nc[j]) {
                j = next[j - 1];
            }
            if (nc[i] == nc[j]) {
                j++;
            }
            next[i] = j;
        }

        j = 0;
        for (int i = 0; i < n; i++) {
            while (j > 0 && hc[i] != nc[j]) {
                j = next[j - 1];
            }
            if (hc[i] == nc[j]) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        String[] haystack = { "hello", "aaaaa", "", "mississippi" };
        String[] needle = { "ll", "bba", "", "mississippi" };
        Solution s = new Solution();
        for (int i = 0; i < needle.length; i++) {
            System.out.println(s.strStr(haystack[i], needle[i]));
        }
    }
}