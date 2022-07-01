import java.util.*;

/**
 * 327. Count of Range Sum
 * Hard
 */
public class Solution {

    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        Set<Long> set = new TreeSet<>();
        for (long s : prefixSum) {
            set.add(s);
            set.add(s - upper);
            set.add(s - lower);
        }
        Map<Long, Integer> map = new HashMap<>();
        int i = 0;
        for (Long s : set) {
            map.put(s, i++);
        }

        int[] bit = new int[i + 1];
        int count = 0;
        //lower <= s[i]-s[j] <= upper, s[i] - upper <= s[j] <= s[i] - lower
        for (long p : prefixSum) {
            int l = map.get(p - upper), r = map.get(p - lower);
            count += query(bit, r + 1) - query(bit, l);
            update(bit, map.get(p) + 1, 1);
        }
        return count;
    }

    private int lowbit(int x) {
        return x & (-x);
    }

    private int query(int[] bit, int i) {
        int s = 0;
        while (i > 0) {
            s += bit[i];
            i -= lowbit(i);
        }
        return s;
    }

    private void update(int[] bit, int i, int val) {
        while (i < bit.length) {
            bit[i] += val;
            i += lowbit(i);
        }
    }

    public static void main(String[] args) {
        int[][] nums = { { -2, 5, -1 }, {0} };
        int[] lower = { -2, 0 };
        int[] upper = { 2, 0 };
        Solution sol = new Solution();
        for (int i = 0; i < upper.length; i++) {
            System.out.println(sol.countRangeSum(nums[i], lower[i], upper[i]));
        }
    }
}
