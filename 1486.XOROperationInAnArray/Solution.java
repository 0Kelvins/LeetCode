/**
 * 1486. XOR Operation in an Array
 * Easy
 * 异或运算优先级比较低，要注意加括号
 */
public class Solution {

    public int xorOperation(int n, int start) {
        if (n == 1) {
            return start;
        }
        int h = n >> 1;
        if((n & 1) == 0) {
            return xorOperation(h, start) ^ xorOperation(h, start + (h << 1));
        }
        return xorOperation(h, start) ^ xorOperation(h, start + (h << 1)) ^ (start + ((n - 1) << 1));
    }

    public static void main(String[] args) {
        int[] n = { 5, 4, 1, 10 };
        int[] start = { 0, 3, 7, 5 };
        Solution s = new Solution();
        for (int i = 0; i < start.length; i++) {
            System.out.println(s.xorOperation(n[i], start[i]));
        }
    }
}
