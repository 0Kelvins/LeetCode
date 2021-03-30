import java.util.*;

/**
 * 29. Dicxvide Two Integers
 * Medium
 * 类似快速幂，极小值处理比较麻烦
 */
public class Solution {

    public int divide(int dividend, int divisor) {
        if (divisor == 1)
            return dividend;
        if (divisor == -1)
            return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
        List<Long> divs = new ArrayList<>();
        List<Long> count = new ArrayList<>();
        boolean sign = (dividend >= 0 && divisor >= 0 || dividend < 0 && divisor < 0) ? true : false;
        long r = 0, x = Math.abs((long)dividend), y = Math.abs((long)divisor), c;
        for (long i = y, j = 1; i <= x; i += i, j += j) {
            divs.add(i);
            count.add(j);
        }
        for (int i = divs.size() - 1; i >= 0; i--) {
            y = divs.get(i);
            c = count.get(i);
            // System.out.println(x + " " + y);
            while (x >= y) {
                x -= y;
                r += c;
            }
        }
        return sign ? (int) r : (int) -r;
    }

    public static void main(String[] args) {
        int[][] in = { { 10, 3 }, { 7, -3 }, { 0, 1 }, { 1, 1 }, { -1, -10 }, {2, 2}, {-2147483648, -1}, {-2147483648, -3} };
        Solution sol = new Solution();
        for (int i = 0; i < in.length; i++) {
            System.out.println(sol.divide(in[i][0], in[i][1]));
        }
    }
}
