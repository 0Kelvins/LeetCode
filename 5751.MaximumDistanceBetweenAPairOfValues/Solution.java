/**
 * 5751. Maximum Distance Between a Pair of Values
 * Medium
 */
public class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0, j = 0, max = 0;
        while (i < nums1.length && j < nums2.length) {
            while (++j < nums2.length && nums1[i] <= nums2[j]) {
                max = Math.max(max, j-i);
            }
            i++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] nums1 = { { 55, 30, 5, 4, 2 },{2,2,2},{30,29,19,5},{5,4} };
        int[][] nums2 = { { 100, 20, 10, 10, 5 },{10,10,1},{25,25,25,25,25},{3,2} };
        Solution s = new Solution();
        for (int i = 0; i < nums2.length; i++) {
            System.out.println(s.maxDistance(nums1[i], nums2[i]));
        }
    }
}
