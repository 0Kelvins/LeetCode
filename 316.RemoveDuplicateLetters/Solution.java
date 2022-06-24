/**
 * 316. Remove Duplicate Letters
 * Medium
 * 单调栈
 */
public class Solution {

    public String removeDuplicateLetters(String s) {
        boolean[] has = new boolean[26];
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            if (!has[i]) {
                while (builder.length() > 0 && builder.charAt(builder.length() - 1) > c) {
                    int j = builder.charAt(builder.length() - 1) - 'a';
                    if (nums[j] > 0) {
                        builder.deleteCharAt(builder.length() - 1);
                        has[j] = false;
                    } else {
                        break;
                    }
                }
                has[i] = true;
                builder.append(c);
            }
            nums[i]--;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] strs = { "bcabc", "cbacdcbc" };
        for (String s : strs) {
            System.out.println(sol.removeDuplicateLetters(s));
        }
    }
}
