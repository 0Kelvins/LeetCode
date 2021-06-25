import java.util.Arrays;

/**
 * 268. Missing Number
 * Easy
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length + 1;
        int sum = Arrays.stream(nums).sum();
        int nsum = n * (n - 1) / 2;
        return nsum - sum;
    }
}