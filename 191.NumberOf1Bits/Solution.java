/**
 * 191. Number of 1 Bits
 * Easy
 * 这才是简单题好吧（虽然还是错了
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((1 << i & n) != 0) {    // 最高位为1时为负数！
                count++;
            }
        }
        return count;
    }
}
