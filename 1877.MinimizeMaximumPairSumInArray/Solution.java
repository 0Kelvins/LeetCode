import java.util.Arrays;

/**
 * 1877. Minimize Maximum Pair Sum in Array
 * Medium-----
 */
public class Solution {

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = 0, i = 0, j = nums.length - 1;
        while (i < j) {
            max = Math.max(nums[i++] + nums[j--], max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] nums = { { 3, 5, 2, 3 }, { 3, 5, 4, 2, 4, 6 } };
        Solution s = new Solution();
        for (int[] ns : nums) {
            System.out.println(s.minPairSum(ns));
        }
    }
}