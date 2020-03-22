import java.io.*;
import java.util.*;

/**
 * 115. Distinct Subsequences
 * emm，其实还是比较简单的DP，不过还是需要多练，总是要想半天才能分离好状态
 * 最基本的实现以后就比较好优化了，优化略。
 */
class Solution {
    public int numDistinct(String s, String t) {
        int sl = s.length(), tl = t.length();
        int[] dp = new int[sl]; // dp[j]:s[j]之前对应t[0~i]有多少种解
        int sum, pre;
        for (int i = 0; i < tl; i++) {
            sum = i > 0 ? 0 : 1;
            for (int j = 0; j < sl; j++) {
                pre = sum;
                sum += dp[j];
                if (j >= i && s.charAt(j) == t.charAt(i))
                    dp[j] = pre;
                else
                    dp[j] = 0;
            }
        }
        sum = 0;
        for (int i = 0; i < sl; i++)
            sum += dp[i];
        return sum;
    }

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        File f = new File("input.txt");
        Scanner scan = new Scanner(f);
        while (scan.hasNext()) {
            String a = scan.next();
            String b = scan.next();
            System.out.println(s.numDistinct(a, b));
        }
        scan.close();
    }
}