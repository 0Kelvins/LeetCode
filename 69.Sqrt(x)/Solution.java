/**
 * 69. Sqrt(x)
 * Easy
 */
public class Solution {
    public int mySqrt(int x) {
        long l = 0, r = ((long)x + 1) / 2;
        while (l < r) {
            long m = (l + r + 1) / 2;
            long p = (long)m * m;
            if (p > x) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        return (int)l;
    }

    public static void main(String[] args) {
        int[] x = {2147483647}; //0, 1, 2, 4, 8, 9, 10, 2147395599, 
        Solution s = new Solution();
        for (int i : x) {
            System.out.println(s.mySqrt(i));
        }
    }
}
