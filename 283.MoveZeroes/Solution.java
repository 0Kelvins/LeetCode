/**
 * 283. Move Zeroes
 * Easy
 */
public class Solution {

    public void moveZeroes(int[] nums) {
        int zeros = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeros++;
            } else {
                nums[i - zeros] = nums[i];
            }
        }
        for (int i = n - zeros; i < n; i++) {
            nums[i] = 0;
        }
    }
}