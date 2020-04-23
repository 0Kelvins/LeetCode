/**
 * 154. Find Minimum in Rotated Sorted Array II
 * 我一开始的思路时把左侧所有相同的跳过，虽然效率差不多，但显然没有这个简洁
 */
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, m;
        while (left < right) {
            m = left + (right - left) / 2;
            if (nums[m] > nums[right])
                left = m + 1;
            else if (nums[m] < nums[right])
                right = m;
            else // 无法确定最小值位置时，逐步缩小边界
                right--;
        }
        return nums[left];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] inputs = { { 1, 3, 5 }, { 2, 2, 2, 0, 1 }, { 1 }, { 2, 1, 2, 2, 2 }, { 1, 2, 0, 1 }, { 3, 3, 1, 3 },
                { 1, 1, 1 } };
        for (int[] nums : inputs) {
            System.out.println(s.findMin(nums));
        }
    }
}