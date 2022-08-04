import java.util.*;

/**
 * 899. Orderly Queue
 * Hard
 */
public class Solution {

    public String orderlyQueue(String s, int k) {
        String min = s;
        if (k == 1) {
            StringBuilder builder = new StringBuilder(s);
            for (int i = 0; i < s.length(); i++) {
                char c = builder.charAt(0);
                builder.deleteCharAt(0);
                builder.append(c);
                String t = builder.toString();
                if (t.compareTo(min) < 0) {
                    min = t;
                }
            }
        } else {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            min = new String(chars);
        }
        return min;
    }

    public static void main(String[] args) {
        String[] s = { "cba", "baaca", "acaaaa", "cba" };
        int[] k = { 1, 3, 1, 3 };
        Solution sol = new Solution();
        for (int i = 0; i < k.length; i++) {
            System.out.println(sol.orderlyQueue(s[i], k[i]));
        }
    }
}