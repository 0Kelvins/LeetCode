import java.util.*;

/**
 * 377. Combination Sum IV
 * Medium
 * DP就一看就知道要用，一写就写不出来。
 */
public class Solution {

    private Map<Integer, Integer> map;

    private int find(TreeSet<Integer> set, int k) {
        if (k < set.first()) {
            return 0;
        }
        int count = 0;
        if (set.contains(k)) {
            count++;
        }
        int i = 0, t;
        for (Iterator<Integer> it = set.iterator(); i < k && it.hasNext();) {
            i = k - it.next();
            if (map.containsKey(i)) {
                t = map.get(i);
            } else {
                t = find(set, i);
                map.put(i, t);
            }
            count += t;
        }
        return count;
    }

    // 回溯，存储回溯过的路径就勉强够时间
    public int combinationSum4Recur(int[] nums, int target) {
        TreeSet<Integer> set = new TreeSet<>();
        for (Integer i : nums) {
            set.add(i);
        }
        map = new HashMap<>();
        return find(set, target);
    }

    // DP
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1; // 目标0没有一个元素构成1种方案
        for (int i = 1; i <= target; i++) {
            for (int n : nums) {
                if (n <= i) {
                    dp[i] += dp[i - n];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[][] nums = { { 1, 2, 3 }, { 9 }, { 1, 2, 3 }, { 1, 2, 3 } };
        int[] target = { 4, 3, 7, 10 };
        Solution s = new Solution();
        for (int i = 0; i < target.length; i++) {
            System.out.println(s.combinationSum4(nums[i], target[i]));
        }
    }
}
