import java.io.*;
import java.util.*;

/**
 * 97. Interleaving String
 * 这题其实不难，不过要优化好需要花些时间
 * 动态规划这里比DFS要慢一点
 */
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        if (n1 + n2 != n3)
            return false;
        int[] dp = new int[n1 + 1];
        dp[0] = 0;
        for (int i = 1; i <= n1; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1] != -1)
                dp[i] = dp[i - 1] + 1;
            else
                dp[i] = -1;
        }
        for (int i = 1; i <= n2; i++) {
            dp[0] = dp[0] != -1 && s2.charAt(i - 1) == s3.charAt(i - 1) ? i : -1;
            for (int j = 1; j <= n1; j++) {
                char c = s3.charAt(i + j - 1);
                if (s1.charAt(j - 1) == c && dp[j - 1] != -1)
                    dp[j] = dp[j - 1] + 1;
                else if (s2.charAt(i - 1) == c && dp[j] != -1)
                    dp[j]++;
                else
                    dp[j] = -1;
            }
        }
        return dp[n1] == n3;
    }

    public static void main(String[] args) throws IOException {
        File f = new File("input.txt");
        Scanner scan = new Scanner(f);
        Solution s = new Solution();
        while (scan.hasNext()) {
            String in = scan.nextLine();
            String[] ss = in.split(" ");
            System.out.println(s.isInterleave(ss[0], ss[1], ss[2]));
        }
        scan.close();
    }
}