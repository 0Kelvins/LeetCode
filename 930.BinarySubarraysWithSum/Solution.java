import java.util.*;

/**
 * 930. Binary Subarrays With Sum
 * Medium
 */
public class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            sum += i;
            count += map.getOrDefault(sum - goal, 0);
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] nums = { { 1, 0, 1, 0, 1 }, { 0, 0, 0, 0, 0 } };
        int[] goal = { 2, 0 };
        Solution s = new Solution();
        for (int i = 0; i < goal.length; i++) {
            System.out.println(s.numSubarraysWithSum(nums[i], goal[i]));
        }
    }
}
