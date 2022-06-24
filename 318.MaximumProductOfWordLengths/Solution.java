/**
 * 318. Maximum Product of Word Lengths
 * Medium
 */
public class Solution {

    public int maxProduct(String[] words) {
        int n = words.length;
        int[] alphabet = new int[n];
        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray()) {
                alphabet[i] |= 1 << (c - 'a'); // |来保存所有字符，1<<x来得到字符对应位
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((alphabet[i] & alphabet[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String[][] all_words = {{"abcw","baz","foo","bar","xtfn","abcdef"},
                {"a","ab","abc","d","cd","bcd","abcd"},
                { "a", "aa", "aaa", "aaaa" } };
        Solution sol = new Solution();
        for (String[] words : all_words) {
            System.out.println(sol.maxProduct(words));
        }
    }
}