/**
 * 62. 圆圈中最后剩下的数字
 * Easy?
 * 这题数学公式搞清楚就很简单。
 */
public class Solution {
    public int lastRemaining(int n, int m) {
        int f = 0;
        for(int i = 2; i <= n; i++) {
            f = (f + m) % i;
        }
        return f;
    }
}
