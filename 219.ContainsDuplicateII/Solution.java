import java.util.*;

/**
 * 219. Contains Duplicate II
 * Easy
 * 滑动窗口内数据用hash维护比线性搜索更快
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length < 2 || k == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            if (i >= k) {
                set.remove(nums[i - k]);
            }
            set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = { { 1, 2, 3, 1 }, { 1, 0, 1, 1 }, { 1, 2, 3, 1, 2, 3 } };
        int[] k = { 3, 1, 2 };
        Solution s = new Solution();
        for (int i = 0; i < k.length; i++) {
            System.out.println(s.containsNearbyDuplicate(nums[i], k[i]));
        }
    }
}
