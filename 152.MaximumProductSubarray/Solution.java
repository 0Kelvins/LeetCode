/**
 * 152. Maximum Product Subarray
 * 对DP的思路还是太僵化
 */
class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, tmax = 1, tmin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) { // 这步很重要！就这步自己没想出来
                int t = tmax;
                tmax = tmin;
                tmin = t;
            }
            tmax = Math.max(tmax * nums[i], nums[i]);
            tmin = Math.min(tmin * nums[i], nums[i]);
            max = Math.max(max, tmax);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] nums = { { 2, 3, -2, 4 }, { -2, 0, -1 }, { -2, 1, -4 } };
        for (int[] arr : nums) {
            System.out.println(s.maxProduct(arr));
        }
    }
}