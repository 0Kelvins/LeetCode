/**
 * 153. Find Minimum in Rotated Sorted Array
 * 二分查找
 */
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, m;
        while (left < right) {
            m = (left + right) / 2;
            if (nums[m] > nums[right]) // nums[m]比右边大时一定在大数里，最后会移到最大值处，left就可以取到最小值
                left = m + 1;
            else
                right = m; // m向下取整不会死循环
        }
        return nums[left];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] inputs = { { 3, 4, 5, 1, 2 }, { 4, 5, 6, 7, 0, 1, 2 }, { 4, 5, 1, 2, 3 }, { 1, 2 }, { 2, 1 }, { 1 } };
        for (int[] nums : inputs) {
            System.out.println(s.findMin(nums));
        }
    }
}