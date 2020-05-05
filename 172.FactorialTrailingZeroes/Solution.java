/**
 * 172. Factorial Trailing Zeroes
 * 数学题，因为要算5的幂次，所以要注意除数是否出界，多次优化过程后即可
 */
class Solution {
    public int trailingZeroes(int n) {
        int zero = 0;
        while (n > 0) {
            n /= 5;
            zero += n;
        }
        return zero;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] in = { 3, 5, 10, 25, 100, 1808548329 };
        for (int i : in) {
            System.out.println(s.trailingZeroes(i));
        }
    }
}