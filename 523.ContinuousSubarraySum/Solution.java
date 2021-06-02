import java.util.*;

/**
 * 523. Continuous Subarray Sum
 * Meidum
 * 直接计算每个区间会超时，利用前缀和之间的差值为k时，两个前缀和对k的余数相同
 */
public class Solution {

    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int remainder = 0;
        for (int i = 0; i < n; i++) {
            remainder = (remainder + nums[i]) % k;
            if (map.containsKey(remainder)) {
                int pre = map.get(remainder);
                if (i - pre >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = { { 23, 2, 4, 6, 7 }, { 23, 2, 6, 4, 7 }, { 23, 2, 6, 4, 7 }, { 23, 2, 4, 6, 6 } };
        int[] k = { 6, 6, 13, 7 };
        Solution s = new Solution();
        for (int i = 0; i < k.length; i++) {
            System.out.println(s.checkSubarraySum(nums[i], k[i]));
        }
    }
}