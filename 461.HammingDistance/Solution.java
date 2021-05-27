/**
 * 461. Hamming Distance
 * Easy
 */
public class Solution {

    public int hammingDistance(int x, int y) {
        int xor = x ^ y, count = 0;
        while (xor > 0) {
            xor &= (xor - 1); // 消去最右侧1位
            count++;
        }
        return count;
    }
}