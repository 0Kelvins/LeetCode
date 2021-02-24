import java.math.BigInteger;
/**
 * 剑指 Offer 14- II. 剪绳子 II
 * Medium
 * 使用了动态规划，可以通过循环取余或快速幂改进
 */
public class Solution {

    public int cuttingRope(int n) {
        BigInteger[] dp = new BigInteger[n + 1];
        dp[0] = dp[1] = BigInteger.valueOf(0);
        dp[2] = BigInteger.valueOf(1);
        for (int i = 3; i < n + 1; i++) {
            BigInteger t = BigInteger.valueOf(2 * (i - 2)).max(dp[i - 2].multiply(BigInteger.valueOf(2)));
            BigInteger p = BigInteger.valueOf(3 * (i - 3)).max(dp[i - 3].multiply(BigInteger.valueOf(3)));
            dp[i] = t.max(p);
            System.out.println(dp[i].mod(BigInteger.valueOf(1000000007)).intValue());
        }
        return dp[n].mod(BigInteger.valueOf(1000000007)).intValue();
    }

    // 快速幂
    public int cuttingRope2(int n) {
        if (n < 4)
            return n - 1;
        int b = n % 3, m = 1000000007; // m 除余值
        long res = 1, x = 3;    // x 底数
        for(int a = n / 3 - 1; a > 0; a /= 2) { // a 指数
            if(a % 2 == 1) res = (res * x) % m;
            x = (x * x) % m;
        }
        if(b == 0) return (int)(res * 3 % m);   // 被3整除
        if(b == 1) return (int)(res * 4 % m);   // 余4
        return (int)(res * 6 % m);              // 余2
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = { 2, 10, 58, 8, 120, 1000 }; 
        for (int i : nums) {
            System.out.println(s.cuttingRope2(i));
        }
    }
}