/**
 * 17.10. Find Majority Element LCCI
 * "Easy"
 * 摩尔投票，非主要数就减，主要数就加
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int candidate = -1, count = 0, n = nums.length;
        for (int i : nums) {
            if (count == 0) {
                candidate = i;
            }
            if (i == candidate) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for (int i : nums) {
            if (i == candidate) {
                count++;
            }
        }
        return count * 2 > n ? candidate : -1;
    }

    public static void main(String[] args) {
        int[][] nums = { { 1, 2, 5, 9, 5, 9, 5, 5, 5 }, { 3, 2 }, { 2, 2, 1, 1, 1, 2, 2 } };
        Solution s = new Solution();
        for (int[] ns : nums) {
            System.out.println(s.majorityElement(ns));
        }
    }
}
