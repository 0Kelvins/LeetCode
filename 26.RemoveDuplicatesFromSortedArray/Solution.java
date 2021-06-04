/**
 * 26. Remove Duplicates from Sorted Array
 * Easy
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0, n = nums.length;
        while (j < n) {
            if (i == j || nums[i] == nums[j]) {
                j++;
            } else if (nums[i] != nums[j]) {
                nums[++i] = nums[j++];
            }
        }
        return i + 1;
    }
}
