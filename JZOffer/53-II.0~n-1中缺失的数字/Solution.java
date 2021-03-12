/**
 * 53 - II. 0～n-1中缺失的数字
 * Easy
 * 这里的二分查找条件要留心下
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1, mid;
        while (i <= j) {
            mid = i + (j - i) / 2;
            if (nums[mid] == mid)   // 数值和下标是否对应
                i = mid + 1;
            else
                j = mid - 1;
        }
        return i;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] numbers = { { 0, 1, 3 }, { 0, 1, 2, 3, 4, 5, 6, 7, 9 }, {1, 2} };
        for (int[] nums : numbers) {
            System.out.println(sol.missingNumber(nums));
        }
    }
}
