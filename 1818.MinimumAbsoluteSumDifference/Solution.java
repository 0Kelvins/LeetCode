import java.util.*;

/**
 * 1818. Minimum Absolute Sum Difference
 * Medium
 * 用TreeSet代替了数组，构建set浪费了时间，数组+二分会更快
 */
public class Solution {

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length, max_diff = 0, sum = 0, mod = (int) 1e9 + 7;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i = 0; i < n; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            Integer f = set.floor(nums2[i]), c = set.ceiling(nums2[i]);
            f = f == null ? (int) 1e5 : f;
            c = c == null ? (int) 1e5 : c;
            int floor = Math.abs(nums2[i] - f);
            int ceil = Math.abs(nums2[i] - c);
            int min_d = Math.min(floor, ceil);
            if (min_d < d) {
                max_diff = Math.max(d - min_d, max_diff);
            }
            sum = (sum + d) % mod; // 要注意溢出
        }
        return (sum - max_diff + mod) % mod; // 要注意溢出
    }

    public static void main(String[] args) {
        int[][] nums1 = { { 1, 7, 5 }, { 2, 4, 6, 8, 10 }, { 1, 10, 4, 4, 2, 7 }, {100, 202, 200} };
        int[][] nums2 = { { 2, 3, 5 }, { 2, 4, 6, 8, 10 }, { 9, 3, 5, 1, 7, 4 }, {1, 200, 200} };
        Solution s = new Solution();
        for (int i = 0; i < nums2.length; i++) {
            System.out.println(s.minAbsoluteSumDiff(nums1[i], nums2[i]));
        }
    }
}