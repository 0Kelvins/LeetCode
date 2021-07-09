/**
 * 287. Find the Duplicate Number
 * Meidum
 * 桶排序、快慢指针
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast); // slow = a+b, fast = 2(slow) = 2(a+b) = a+b+n*l, l = len(circle)
        fast = 0;
        while (slow != fast) {  // slow = b+a, fast = 0+a, a = (n-1)*l+(l-b)
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[][] nums = { { 1, 3, 4, 2, 2 }, { 3, 1, 3, 4, 2 }, { 1, 1 }, { 1, 1, 2 } };
        Solution s = new Solution();
        for (int[] ns : nums) {
            System.out.println(s.findDuplicate(ns));
        }
    }
}
