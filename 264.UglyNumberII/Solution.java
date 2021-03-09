import java.util.*;

/**
 * 264. Ugly Number II
 * Medium
 * Map或Set的contain()方法在这里代价相对是高的，故不及逐个求解丑数
 */
public class Solution {
    private int[] nums;

    Solution() {
        nums = new int[1690];
        nums[0] = 1;
        int ugly, i2 = 0, i3 = 0, i5 = 0;

        for(int i = 1; i < 1690; ++i) {
            ugly = Math.min(Math.min(nums[i2] * 2, nums[i3] * 3), nums[i5] * 5);
            nums[i] = ugly;

            if (ugly == nums[i2] * 2) ++i2;
            if (ugly == nums[i3] * 3) ++i3;
            if (ugly == nums[i5] * 5) ++i5;
        }
    }

    public int nthUglyNumber(int n) {
        return nums[n - 1];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = { 1, 10, 100, 1690 };
        for (int n : nums) {
            System.out.println(sol.nthUglyNumber(n));
        }
    }
}
