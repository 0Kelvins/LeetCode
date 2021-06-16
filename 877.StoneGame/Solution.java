/**
 * 877. Stone Game
 * Meidum
 */
public class Solution {

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = piles[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) { // 当前玩家与另一个玩家的石子数量之差的最大值
                dp[j] = Math.max(piles[i] - dp[j], piles[j] - dp[j - 1]);
            }
        }
        return dp[n - 1] > 0;
    }

    public static void main(String[] args) {
        int[][] piles = { { 5, 3, 4, 5 }, { 1, 2, 3, 4 } };
        Solution s = new Solution();
        for (int[] pile : piles) {
            System.out.println(s.stoneGame(pile));
        }
    }
}
