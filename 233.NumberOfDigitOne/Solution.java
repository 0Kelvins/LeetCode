/**
 * 233. Number of Digit One
 * Hard
 * 就嗯找数学规律。
 */
public class Solution {

    public int countDigitOne(int n) {
        long i = 1, divider;
        int count = 0;
        while (i <= n) {
            divider = i * 10;
            count += (n / divider) * i + Math.min(Math.max(n % divider - i + 1, 0l), i);
            i *= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] in = { 0, 1, 9, 10, 12, 100, 232 };
        Solution s = new Solution();
        for (int i : in) {
            System.out.println(s.countDigitOne(i));
        }
    }
}
