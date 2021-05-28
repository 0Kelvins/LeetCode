/**
 * 477. Total Hamming Distance
 * Medium
 * 这题要换视角，通过逐位统计不同的位数来化简
 */
public class Solution {

    public int totalHammingDistance(int[] nums) {
        int n = nums.length, one, count = 0;
        for (int i = 0; i < 32; i++) {
            one = 0; // 每一位为1的数的数量
            for (int j = 0; j < nums.length; j++) {
                one += (nums[j] >> i) & 1;
            }
            count += one * (n - one);
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] nums = { { 4, 14, 2 }, { 4, 14, 4 } };
        Solution sol = new Solution();
        for (int[] ns : nums) {
            System.out.println(sol.totalHammingDistance(ns));
        }
    }
}