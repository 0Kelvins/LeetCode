import java.util.*;

/**
 * 220. Contains Duplicate III
 * Medium
 * 滑动窗口+有序集合
 * 滑动窗口+桶：自定义一个桶Hash的方法，然后利用Map存储窗口内桶对应元素，比较桶以及相邻桶内元素即可
 * 若有重复元素在窗口内，肯定满足条件，故不用担心重复问题
 */
public class Solution {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long celing = set.ceiling((long) nums[i] - (long) t);
            if (celing != null && celing <= ((long) nums[i] + (long) t)) {
                return true;
            }
            set.add((long)nums[i]);
            if (i >= k) {
                set.remove((long)nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = { { 1, 2, 3, 1 }, { 1, 0, 1, 1 }, { 1, 5, 9, 1, 5, 9 }, {}, { 1, 2 }, { 1 }, { 1 },
                { 1, 2, 5, 6, 7, 2, 4 }, { 1, 2, 2, 3, 4, 5 }, { -2147483648, 2147483647 } };
        int[] ks = { 3, 1, 2, 1, 1, 0, 0, 4, 3, 1 };
        int[] ts = { 0, 2, 3, 2, 0, 0, 1, 0, 0, 1 };
        Solution s = new Solution();
        for (int i = 0; i < ts.length; i++) {
            System.out.println(s.containsNearbyAlmostDuplicate(nums[i], ks[i], ts[i]));
        }
    }
}