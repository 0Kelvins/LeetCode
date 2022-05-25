import java.util.*;

/**
 * 312. Burst Balloons
 * Hard
 * 需要逆向的分治这个问题
 */
public class Solution {

    public int maxCoinsDP(int[] nums) {
        int n = nums.length;
        int[][] rec = new int[n + 2][n + 2];
        int[] val = new int[n + 2];
        val[0] = val[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    int sum = val[i] * val[k] * val[j];
                    sum += rec[i][k] + rec[k][j];
                    rec[i][j] = Math.max(rec[i][j], sum);
                }
            }
        }
        return rec[0][n + 1];
    }

    public int maxCoins(int[] nums) {
        int n = nums.length, m = n + 2;
        int[] balloons = new int[m];
        balloons[0] = balloons[m - 1] = 1;
        for (int i = 0; i < n; i++) {
            balloons[i + 1] = nums[i];
        }
        int[] prev = new int[m];
        int[] next = new int[m];
        for (int i = 0; i < m ; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        return burst(balloons, prev, next, 0);
    }

    private int burst(int[] nums, int[] prev, int[] next, int coins) {
        if (next[0] == nums.length - 1) {
            return coins;
        }
        int max = 0, p = 0;
        while (next[p] < nums.length - 1) {
            p = next[p];
            int t = nums[prev[p]] * nums[p] * nums[next[p]];
            coins += t;
            prev[next[p]] = prev[p];
            next[prev[p]] = next[p];
            int m = burst(nums, prev, next, coins);
            coins -= t;
            prev[next[p]] = p;
            next[prev[p]] = p;
            max = Math.max(max, m);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] in = { { 3, 1, 5, 8 }, { 1, 5 } };
        Solution s = new Solution();
        for (int[] nums : in) {
            System.out.println(s.maxCoins(nums));
        }
    }
}
