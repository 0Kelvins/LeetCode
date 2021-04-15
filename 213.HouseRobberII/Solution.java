/**
 * 213. House Robber II
 * Medium
 * DP变种，需要想到通过指定范围来区别边界
 */
public class Solution {

    private int dp(int[] nums, int start, int end) {
        int first = nums[start], second = Math.max(first, nums[start + 1]);
        for (int i = start + 2; i < end; i++) {
            int t = second;
            second = Math.max(first + nums[i], second);
            first = t;
        }
        return second;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        if (n == 2)
            return Math.max(nums[0], nums[1]);
            
        return Math.max(dp(nums, 0, n - 1), dp(nums, 1, n));
    }

    public static void main(String[] args) {
        int[][] numbers = { { 2, 3, 2 }, { 1, 2, 3, 1 }, { 0 }, { 4, 1, 2, 7, 5, 3, 1 } };
        Solution s = new Solution();
        for (int[] nums : numbers) {
            System.out.println(s.rob(nums));
        }
    }
}