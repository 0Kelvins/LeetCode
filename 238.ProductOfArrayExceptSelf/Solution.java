import java.util.Arrays;

/**
 * 238. Product of Array Except Self
 * Meidum
 * 可以优化以下空间
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n], suffix = new int[n];
        prefix[0] = 1;
        suffix[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
            suffix[n - 1 - i] = suffix[n - i] * nums[n - i];
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = prefix[i] * suffix[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] nums = { { 1, 2, 3, 4 }, { -1, 1, 0, -3, 3 } };
        Solution s = new Solution();
        for (int[] ns : nums) {
            System.out.println(Arrays.toString(s.productExceptSelf(ns)));
        }
    }
}
