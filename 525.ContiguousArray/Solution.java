import java.util.*;

/**
 * 525. Contiguous Array
 * Medium
 */
public class Solution {

    public int findMaxLength(int[] nums) {
        int n = nums.length, maxLen = 0, counter = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(counter, -1);
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                counter++;
            } else {
                counter--;
            }
            if (map.containsKey(counter)) {
                int pre = map.get(counter);
                maxLen = Math.max(maxLen, i - pre);
            } else {
                map.put(counter, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[][] nums = { { 0, 1 }, { 0, 1, 0 } };
        Solution s = new Solution();
        for (int[] ns : nums) {
            System.out.println(s.findMaxLength(ns));
        }
    }
}