import java.io.*;
import java.util.*;

/**
 * 91. Decode Ways
 * 知道要DP，但是就是想不起来怎么分离不同状态。
 */
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (s == null || n == 0) // 特设空串无解
            return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1; // 空串1种解
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        int one, two;
        for (int i = 2; i <= n; i++) {
            one = Integer.valueOf(s.substring(i - 1, i));
            two = Integer.valueOf(s.substring(i - 2, i));
            if (one != 0)
                dp[i] += dp[i - 1];
            if (two >= 10 && two <= 26)
                dp[i] += dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        File f = new File("input.txt");
        Scanner scan = new Scanner(f);
        // Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String code = scan.next();
            System.out.println(code + " " + s.numDecodings(code));
        }
        scan.close();
    }
}