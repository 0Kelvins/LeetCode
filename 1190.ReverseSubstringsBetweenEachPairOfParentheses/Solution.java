import java.util.Deque;
import java.util.LinkedList;

/**
 * 1190. Reverse Substrings Between Each Pair of Parentheses
 * Meidum
 */
public class Solution {

    public String reverseParentheses0(String s) {
        Deque<String> stack = new LinkedList<>();
        StringBuffer str = new StringBuffer();
        for (Character c : s.toCharArray()) {
            if (c == '(') {
                stack.push(str.toString());
                str.setLength(0);
            } else if (c == ')') {
                str.reverse();
                str.insert(0, stack.pop());
            } else {
                str.append(c);
            }
        }
        return str.toString();
    }

    public String reverseParentheses(String s) {
        int n = s.length();
        Deque<Integer> idxStack = new LinkedList<>();
        int[] pairs = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                idxStack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = idxStack.pop();
                pairs[i] = j;
                pairs[j] = i;
            }
        }

        StringBuffer str = new StringBuffer();
        int i = 0, direct = 1;
        while (i < n) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = pairs[i];
                direct = -direct;
            } else {
                str.append(s.charAt(i));
            }
            i += direct;
        }
        
        return str.toString();
    }

    public static void main(String[] args) {
        String[] str = { "(abcd)", "(u(love)i)", "(ed(et(oc))el)", "a(bcdefghijkl(mno)p)q", "ta()usw((((a))))" };
        Solution sol = new Solution();
        for (String s : str) {
            System.out.println(sol.reverseParentheses(s));
        }
    }
}