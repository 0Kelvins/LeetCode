import java.util.*;

/**
 * 1403. Minimum Subsequence in Non-Increasing Order
 * Easy
 */
public class Solution {

    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int p = binarySearch(sum, 0, nums.length, (float)sum[nums.length] / 2);
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length - 1; i >= p; i--) {
            res.add(nums[i]);
        }
        return res;
    }
    
    private int binarySearch(int[] sum, int i, int j, float key) { // key不保留小数会比较不正确
        int m = (j - i) / 2 + i;
        if (sum[m] < key && sum[m + 1] >= key) {
            return m;
        } else if (sum[m + 1] < key) {
            i = m + 1;
        } else {
            j = m - 1;
        }
        return binarySearch(sum, i, j, key);
    }

    public static void main(String[] args) {
        int[][] nums = { { 4, 3, 10, 9, 8 }, { 4, 4, 7, 6, 7 }, { 6 }, {1} };
        Solution sol = new Solution();
        for (int[] num : nums) {
            List<Integer> res = sol.minSubsequence(num);
            System.out.println(res.toString());
        }
    }
}
