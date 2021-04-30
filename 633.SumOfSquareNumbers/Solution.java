/**
 * 633. Sum of Square Numbers
 * Meidum
 * 直接用开根号效率低，双指针法要证明不会错过正确值
 */
public class Solution {

    public boolean judgeSquareSum(int c) {
        int a = 0, b = (int)Math.sqrt(c), ss;
        while (a <= b) {
            ss = a * a + b * b;
            if (ss == c) {
                return true;
            } else if (ss > c) {
                b--;
            } else {
                a++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] cs = { 5, 4, 3, 2, 1, 0, 37 };
        Solution s = new Solution();
        for (int c : cs) {
            System.out.println(s.judgeSquareSum(c));
        }
    }
}