/**
 * 231. Power of Two
 * Easy
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n > 0) {
            int count = 0;
            while (n > 0) {
                int bit = n & 1;
                if (bit == 1) {
                    count++;
                    if (count > 1) {
                        return false;
                    }
                }
                n = n >> 1;
            }
            return count == 1;
        }
        return false;
    }

    // x & (-x)可以得到最右侧为1的位
    public boolean isPowerOfTwo2(int n) {
        if (n == 0) return false;
        long x = (long) n;
        return (x & (-x)) == x;
    }
}
