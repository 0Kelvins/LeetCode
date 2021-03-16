import java.util.*;

/**
 * 60. n个骰子的点数
 * Medium
 * 第一反应dp，然后状态转移想不出来。然后暴力果然超时，最后还是看人家题解。。
 */
public class Solution {

    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] t = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    t[j + k] += dp[j] / 6.0;
                }
            }
            dp = t;
        }
        return dp;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = { 1, 2, 3, 4, 5 };
        for (int n : nums) {
            double[] res = sol.dicesProbability(n);
            for (double r : res)
                System.out.print(String.format("%.5f", r) + " ");
            System.out.println();
        }
    }
}