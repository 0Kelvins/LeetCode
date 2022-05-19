/**
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * Medium
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] mp = new int[n];
        int[] max = new int[n];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int prevMax = j > 2 ? max[j - 2] : 0;
                mp[i] = Math.max(prevMax + prices[i] - prices[j], mp[i]);
            }
            max[i] = Math.max(max[i - 1], mp[i]);
        }
        return max[n - 1];
    }

    public static void main(String[] args) {
        int[][] inputs = { { 1, 2, 3, 0, 2 }, { 1 }, { 1, 4, 2 }, { 6, 1, 6, 4, 3, 0, 2 } };
        Solution s = new Solution();
        for (int[] prices : inputs) {
            System.out.println(s.maxProfit(prices));
        }
    }
}
