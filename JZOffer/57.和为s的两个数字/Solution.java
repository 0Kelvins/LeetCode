/**
 * 57. 和为s的两个数字
 * Easy
 * 双指针，想双向二分查找来着，后来感觉又没必要。后面一题想到求和公式再用双指针就行了
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1, t;
        while (l < r) {
            t = target - nums[l];
            while (nums[r] > t)
                r--;
            if(nums[r] == t)
                break;
            t = target - nums[r];
            while (nums[l] < t)
                l++;
            if(nums[l] == t)
                break;
        }
        return new int[] { nums[l], nums[r] };
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] numbers = { { 2, 7, 11, 15 }, { 10, 26, 30, 31, 47, 60 }, { 14, 15, 16, 22, 53, 60 } };
        int[] targets = { 9, 40, 76 };
        for (int i = 0; i < targets.length; i++) {
            int[] res = sol.twoSum(numbers[i], targets[i]);
            for (int r : res) {
                System.out.print(r + " ");
            }
            System.out.println();
        }
    }
}
