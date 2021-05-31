/**
 * 342. Power of Four
 * Easy
 * mask=(10101010101010101010101010101010)2​
 * mask=(AAAAAAAA)16​
 */
public class Solution {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }

    public static void main(String[] args) {
        int[] nums = { 16, 5, 1 };
        Solution s = new Solution();
        for (int n : nums) {
            System.out.println(s.isPowerOfFour(n));
        }
    }
}
