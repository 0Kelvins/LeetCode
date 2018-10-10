import java.util.Stack;
/**
 * 32. Longest Valid Parentheses
 * hard
 * 直接匹配计数要所有情况考虑到很麻烦，利用所有无法匹配的字符下标来反向求长度
*/
class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) { // find all the indices of not match characters
            if (s.charAt(i) == '(')
                stack.push(i);
            else if (!stack.isEmpty() && s.charAt(stack.peek()) == '(')
                stack.pop();
            else
                stack.push(i);
        }
        
        if (stack.isEmpty()) // all match
            return n;

        int longest = 0, h = n;
        while (!stack.isEmpty()) { // find longest range
            int l = stack.pop();
            longest = Math.max(longest, h - l - 1);
            h = l;
        }
        return Math.max(h, longest);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestValidParentheses("(()"));
        System.out.println(s.longestValidParentheses(")()())"));
        System.out.println(s.longestValidParentheses("()(()"));
        System.out.println(s.longestValidParentheses("())"));
    }
}