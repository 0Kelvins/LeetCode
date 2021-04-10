/**
 * 190. Reverse Bits
 * Easy
 * 这题Easy？可能我老了吧。分治实在太nb了
 */
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = res | (n & 1) << (31 - i);
            n >>>= 1;
        }
        return res;
    }
    
    public static void main(String[] args) {
        String[] input = {"00000010100101000001111010011100", "11111111111111111111111111111101"};
        Solution s = new Solution();
        for (String n : input) {
            System.out.println(n);
            int r = s.reverseBits((int)Long.parseLong(n, 2));
            System.out.println(r + "(" + Integer.toBinaryString(r) + ")");
        }
    }
}
