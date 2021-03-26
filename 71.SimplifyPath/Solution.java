import java.util.*;

/**
 * 71. Simplify Path
 * Medium
 * 确定有限自动机DFA，比split再处理应该快些
 *          /   .   *
 * 0    /   0   1   3
 * 1    .   0   2   3
 * 2   ..   0   3   3
 * 3    *   0   3   3
 */
public class Solution {

    private int[][] m = {
        { 0, 1, 3 },
        { 0, 2, 3 },
        { 0, 3, 3 },
        { 0, 3, 3 }
    };
    
    private int convert(char c) {
        switch (c) {
            case '/':
                return 0;
            case '.':
                return 1;
            default:
                return 2;
        }
    }

    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        int state = 0, toState;
        StringBuilder builder = new StringBuilder();
        stack.addLast("/");
        for (char c : path.toCharArray()) {
            toState = m[state][convert(c)];
            if (state != 0 || toState != 0)
                builder.append(c);
            if (toState == 0) {
                if (state == 2 && stack.size() > 1) {
                    stack.removeLast();
                } else if (state == 3) {
                    // System.out.println(builder.toString());
                    stack.addLast(builder.toString());
                }
                if (builder.length() > 1)
                    builder = new StringBuilder();
            }
            state = toState;
        }
        if (state == 2 && stack.size() > 1) {
            stack.removeLast();
        } else if (state == 3) {
            builder.append("/");
            stack.addLast(builder.toString());
        }
        builder = new StringBuilder();
        for (String s : stack) {
            builder.append(s);
        }
        if (builder.length() > 1)
            builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    public static void main(String[] args) {
        String[] paths = { "/home/", "/../", "/home//foo/", "/a/./b/../../c/", "/c", "/a/.." };
        Solution sol = new Solution();
        for (String path : paths) {
            System.out.println(sol.simplifyPath(path));
        }
    }
}
