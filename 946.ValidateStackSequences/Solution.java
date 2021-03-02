import java.util.Stack;

/**
 * 946. Validate Stack Sequences
 * Medium
 */
public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length, m = popped.length, j = 0;
        if (n != m)
            return false;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (popped[j] == pushed[i]) {
                j++;
                while (!s.empty() && s.peek() == popped[j]) {
                    s.pop();
                    j++;
                }
            } else
                s.push(pushed[i]);
        }
        return s.empty();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] in = { 1, 2, 3, 4, 5 };
        int[][] out = { { 4, 5, 3, 2, 1 }, { 4, 3, 5, 1, 2 }, { 1, 2, 3, 4, 5 }, { 2, 1, 3, 4, 5 }, { 3, 2, 1, 5, 4 } };
        for (int i = 0; i < out.length; i++) {
            System.out.println(s.validateStackSequences(in, out[i]));
        }
    }
}
