/**
 * 202. Happy Number
 * Easy
 * 一点不快乐的快乐数。我暴力硬编码解的，快慢指针的思想比较透彻，所有的不快乐数都会进入链表的环
 */
public class Solution {
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        } else if (n == 2 || n == 4 || n == 16) {
            return false;
        }
        int t = 0;
        while (n > 0) {
            t += Math.pow(n % 10, 2);
            n /= 10;
        }
        return isHappy(t);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 19, 37, 28, 3, 5 };
        Solution s = new Solution();
        for (int n : nums) {
            System.out.println(s.isHappy(n));
        }
    }
}
