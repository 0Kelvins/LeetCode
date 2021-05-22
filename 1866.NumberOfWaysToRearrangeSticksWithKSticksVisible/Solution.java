/**
 * 1866. Number of Ways to Rearrange Sticks With K Sticks Visible
 * Hard
 * 最后一个棍子为i时，有dp[i - 1][j - 1]种
 * 最后一个棍子不为i时，有(i - 1) * dp[i - 1][j]种，即最后一个棍子为x(x取[1,i-1])时，有dp[i - 1][j]种
 * 如4，2，例1 2 4 3，124看见2种的数量等同与123看见两种的数量
 */
public class Solution {

    private static int mod = (int) (1e9 + 7);

    public int rearrangeSticks(int n, int k) {
        long[][] dp = new long[n + 1][k + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + (i - 1) * dp[i - 1][j] % mod) % mod;
            }
        }
        return (int) dp[n][k];
    }

    public static void main(String[] args) {
        int[] n = {3,5,20};
        int[] k = {2,5,11};
        Solution s = new Solution();
        for (int i = 0; i < k.length; i++) {
            System.out.println(s.rearrangeSticks(n[i], k[i]));
        }
    }
}
