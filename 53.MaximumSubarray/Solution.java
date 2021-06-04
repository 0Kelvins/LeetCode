/**
 * 53. Maximum Subarray
 * Easy
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0], t = nums[0];
        for (int i = 1; i < nums.length; i++) {
            t = Math.max(t + nums[i], nums[i]);
            max = Math.max(max, t);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] numbers = { { -2, 1, -3, 4, -1, 2, 1, -5, 4 }, { 1 }, { 5, 4, -1, 7, 8 }, { -1, -2 }, {-1}, {-1,-2,-1} };
        Solution s = new Solution();
        for (int[] nums : numbers) {
            System.out.println(s.maxSubArray(nums));
        }
    }
}
