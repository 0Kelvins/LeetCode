import java.util.*;

/**
 * 740. Delete and Earn
 * Medium
 */
public class Solution {

    private int rob(List<Integer> nums) {
        if (nums.size() == 0) {
            return 0;
        }
        if (nums.size() == 1) {
            return nums.get(0);
        }
        int p1 = Math.max(nums.get(0), nums.get(1)), p2 = nums.get(0);
        for (int i = 2; i < nums.size(); i++) {
            int t = p1;
            p1 = Math.max(nums.get(i) + p2, p1);
            p2 = t;
        }
        return p1;
    }

    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        List<Integer> part = new ArrayList<>();
        part.add(nums[0]);
        int sum = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                int last = part.size() - 1;
                part.set(last, nums[i] + part.get(last));
            } else if (nums[i] - nums[i - 1] == 1) {
                part.add(nums[i]);
            } else {
                sum += rob(part);
                part.clear();
                part.add(nums[i]);
            }
        }
        return sum + rob(part);
    }

    public static void main(String[] args) {
        int[][] nums = { {8,3,4,7,6,6,9,2,5,8,2,4,9,5,9,1,5,7,1,4 }, { 2, 2, 3, 3, 3, 4 }, { 8, 10, 4, 9, 1, 3, 5, 9, 4, 10 } };
        Solution s = new Solution();
        for (int[] ns : nums) {
            System.out.println(s.deleteAndEarn(ns));
        }
    }
}