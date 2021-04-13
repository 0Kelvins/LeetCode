/**
 * 209. Minimum Size Subarray Sum
 * Medium
 * 使用的滑动窗口的方法，不过思路就不清晰，没有直接想到滑动窗口
 * 前缀树+二分查找，这个方法把输入、查找转化了一下，值得思考
 */
public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0, right = 0, pre = 0;
        for (int i = 0; i < nums.length; i++) {
            sum -= pre;
            while (sum < target && right < nums.length) {
                sum += nums[right++];
            }
            if (right == nums.length && sum < target) {
                if (i == 0) {
                    return 0;
                }
                break;
            }
            min = Math.min(right - i, min);
            pre = nums[i];
        }
        return min;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] nums = { { 2, 3, 1, 2, 4, 3 }, { 1, 4, 4 }, { 1, 1, 1, 1, 1, 1, 1, 1 },
                { 5, 5, 5, 5, 5, 1, 1, 1, 10 } };
        int[] target = { 7, 4, 11, 15 };
        for (int i = 0; i < target.length; i++) {
            System.out.println(s.minSubArrayLen(target[i], nums[i]));
        }
    }
}
