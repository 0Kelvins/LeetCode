import java.util.Scanner;

/**
 * 96. Unique Binary Search Trees
 * DP就是快。
 */
class Solution {
    public int numTrees(int n) {
        if (n == 0)
            return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int l = 2; l <= n; l++) {
            for (int i = 1; i <= l; i++)
                dp[l] += dp[i - 1] * dp[l - i];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            System.out.println(s.numTrees(n));
        }
        scan.close();
    }
}