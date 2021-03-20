/**
 * 65. 不用加减乘除做加法
 * Easy
 * 明明一开始思路是这样的，但是写着写着就变复杂了呢
 */
public class Solution {

    public int add(int a, int b) {
        int t;
        while (b != 0) {
            t = (a & b) << 1;   // 进位
            a ^= b;
            b = t;
        }
        return a;
    }

    public static void main(String[] args) {
        int[][] inputs = { { 1, 2 }, { 0, 0 }, {2, 3}, { 231, 123 }, {-2, -6}, {2, -6} };
        Solution sol = new Solution();
        for (int[] i : inputs) {
            System.out.println(sol.add(i[0], i[1]));
        }
    }
}