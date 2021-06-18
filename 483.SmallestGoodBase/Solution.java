/**
 * 483. Smallest Good Base
 * Hard
 * 二项式定理+不等式
 */
public class Solution {

    public String smallestGoodBase(String n) {
        Long nval = Long.valueOf(n);
        int max = (int) Math.floor(Math.log(nval) / Math.log(2));
        for (int m = max; m > 1; m--) {
            int k = (int) Math.pow(nval, 1.0 / m);
            long sum = 1, t = 1;
            for (int i = 1; i <= m; i++) {
                t *= k;
                sum += t;
            }
            if (sum == nval) {
                return Integer.toString(k);
            }
        }
        return Long.toString(nval - 1);
    }

    public static void main(String[] args) {
        String[] strs = { "13", "4681", "1000000000000000000" };
        Solution s = new Solution();
        for (String n : strs) {
            System.out.println(s.smallestGoodBase(n));
        }
    }
}