import java.util.Stack;

/**
 * 20. Valid Parentheses
 * easy
 * 可以写的更简短
 */
class Solution {
    public int getVal(char c) {
        switch (c) {
            case '(':
                return -1;
            case '[':
                return -2;
            case '{':
                return -3;
            case ')':
                return 1;
            case ']':
                return 2;
            case '}':
                return 3;
            default:
                return 0;
        }
    }

    public boolean isValid(String s) {
        if (s.isEmpty()) return true;
        int len = s.length();
        if (len % 2 == 1) return false;
        char[] cs = s.toCharArray();
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(getVal(cs[0]));
        for (int i = 1; i < len; i++) {
            int m = getVal(cs[i]);
            if (m > 0) {
                if (stack.isEmpty())
                    return false;
                int t = stack.pop();
                if (t + m != 0)
                    return false;
            }
            else {
                stack.push(m);
            }
        }
        if (stack.isEmpty())
            return true;
        return false;
    }

    public boolean isValidS(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid("()[]{}"));
        System.out.println(s.isValid("()[]}}"));
        System.out.println(s.isValid("(((("));
    }
}