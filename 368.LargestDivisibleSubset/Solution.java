import java.util.*;

/**
 * 368. Largest Divisible Subset
 * Meidum
 * 一眼看出来是dp，但是就不知道怎么写状态转移，怎么找回来序列
 */
public class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1, max_i = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {   // 前面所有的都可能
                if(nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if(dp[i] > max) {
                max = dp[i];
                max_i = i;
            }
        }
        List<Integer> ans = new LinkedList<>();
        int last = nums[max_i];
        ans.add(last);
        max--;
        for (int i = max_i - 1; i >= 0; i--) {
            if (dp[i] == max && last % nums[i] == 0) { // 先判断前面的子序列个数可以减少取模运算
                ans.add(0, nums[i]);
                max--;
                last = nums[i]; // 后一个数一定要整除前一个数
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] numbers = { { 1, 2, 3 }, { 1, 2, 4, 8 }, { 2, 5, 15, 45, 90 }, { 2, 3, 4, 8 } };
        Solution s = new Solution();
        for (int[] nums : numbers) {
            System.out.println(s.largestDivisibleSubset(nums).toString());
        }
    }
}
