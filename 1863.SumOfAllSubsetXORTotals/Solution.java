/**
 * 1863. Sum of All Subset XOR Totals
 * Easy
 */
public class Solution {

    private int subXOR(int[] nums, int xor, int i) {
        int sum = 0, t;
        for (int j = i; j < nums.length; j++) {
            t = xor ^ nums[j];
            sum += t;
            sum += subXOR(nums, t, j + 1);
        }
        return sum;
    }

    public int subsetXORSum(int[] nums) {
        return subXOR(nums, 0, 0);
    }
}