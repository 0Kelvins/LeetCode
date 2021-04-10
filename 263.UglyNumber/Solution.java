/**
 * 263. Ugly Number
 * Easy
 */
public class Solution {

    public boolean isUgly(int n) {
        while (n > 0) {
            if (n == 1) {
                return true;
            } else if (n % 2 == 0) {
                n /= 2;
            } else if (n % 3 == 0) {
                n /= 3;
            } else if (n % 5 == 0) {
                n /= 5;
            } else {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = { 1, 2, 3, 5, 6, 8, 14 };
        for (int n : nums) {
            System.out.println(n + " " + s.isUgly(n));
        }
    }
}