import java.util.*;

/**
 * 494. Target Sum
 * Meidum
 */
public class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum(), diff = sum - target;
        if (diff < 0 || (diff & 1) == 1) {
            return 0;
        }
        int half = diff / 2;
        int[] dp = new int[half + 1];
        dp[0] = 1;
        for (int x : nums) {
            for (int j = half; j >= x; j--) {
                dp[j] += dp[j - x];
            }
        }
        return dp[half];
    }

    public static void main(String[] args) {
        int[][] nums = { { 1, 1, 1, 1, 1 }, { 1 } };
        int[] target = { 3, 1 };
        Solution sol = new Solution();
        for (int i = 0; i < target.length; i++) {
            System.out.println(sol.findTargetSumWays(nums[i], target[i]));
        }
    }
}
