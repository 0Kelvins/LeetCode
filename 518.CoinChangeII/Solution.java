/**
 * 518. Coin Change 2
 * Meidum
 * 零钱、背包
 */
public class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[][] coins = { { 1, 2, 5 }, { 2 }, { 10 } };
        int[] amount = { 5, 3, 10 };
        Solution s = new Solution();
        for (int i = 0; i < amount.length; i++) {
            System.out.println(s.change(amount[i], coins[i]));
        }
    }
}
