/**
 * 53 - I. 在排序数组中查找数字 I
 */
public class Solution {
    public int search(int[] nums, int target) {
        int right = binarySearch(nums, target);
        if (right < 1 || nums[right - 1] != target)
            return 0;
        return right - binarySearch(nums, target - 1);
    }

    private int binarySearch(int[] nums, int target) {
        if(nums.length == 0)
            return 0;
        int i = 0, j = nums.length - 1, mid;
        while (i <= j) {
            mid = i + (j - i) / 2;
            if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] numbers = { { 5, 7, 7, 8, 8, 10 }, { 5, 7, 7, 8, 8, 10 }, {1} };
        int[] targets = { 8, 6, 1 };
        for (int i = 0; i < targets.length; i++) {
            System.out.println(sol.search(numbers[i], targets[i]));
        }
    }
}
