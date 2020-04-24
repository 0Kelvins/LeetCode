/**
 * 162. Find Peak Element
 * 边界还是别偷懒改下long就行了
 */
class Solution {
    private int binarySearch(int[] nums, int start, int end) {
        int m = start + (end - start) / 2;
        long pre = m == 0 ? Long.MIN_VALUE : nums[m - 1];
        long post = m == nums.length - 1 ? Long.MIN_VALUE : nums[m + 1];
        if (nums[m] > pre && nums[m] > post)
            return m;
        return nums[m] > pre ? binarySearch(nums, m + 1, end) : binarySearch(nums, start, m - 1);
    }

    public int findPeakElement(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] inputs = { { 1, 2, 3, 1 }, { 1, 2, 1, 3, 5, 6, 4 }, { 1 }, { 2, 3 }, { 1, -1 }, { -2147483648 } };
        for (int[] nums : inputs) {
            int r = s.findPeakElement(nums);
            System.out.println(r + " " + nums[r]);
        }
    }
}