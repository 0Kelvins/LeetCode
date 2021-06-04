/**
 * 27. Remove Element
 * Easy
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0, n = nums.length;
        while (j < n) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }
}
