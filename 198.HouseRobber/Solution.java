/**
 * 198. House Robber
 * Medium
 * 简单DP
 */
public class Solution {
    public int rob0(int[] nums) {
        int n = nums.length, k = 2;
        int[][] rob = new int[n + 1][k];
        rob[0][0] = rob[0][1] = 0;

        for (int i = 1; i <= n; i++) {
            rob[i][0] = Math.max(rob[i - 1][0], rob[i - 1][1]);
            rob[i][1] = Math.max(rob[i - 1][1], rob[i - 1][0] + nums[i - 1]);
        }

        return Math.max(rob[n][0], rob[n][1]);
    }
    
    public int rob(int[] nums) {
        int rob = 0, noRob = 0, t;

        for (int i = 0; i < nums.length; i++) {
            t = Math.max(noRob, rob);
            rob = Math.max(rob, noRob + nums[i]);
            noRob = t;  // 注意交换时改变了原值
        }

        return Math.max(rob, noRob);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] nums = { { 1, 2, 3, 1 }, { 2, 7, 9, 3, 1 }, {0}, {1, 2, 3, 4, 5}, {5, 4, 3, 2, 1}, {1, 2, 1, 2}, {1, 1, 1, 1} };
        for (int[] money : nums) {
            System.out.println(s.rob(money));
        }
    }
}
