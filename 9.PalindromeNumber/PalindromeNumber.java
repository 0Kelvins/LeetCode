/**
 * 9. Palindrome Number
 * very easy ←_←
*/
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int r = 0, t = x;
        while (t > 0) {
            r = r * 10 + t % 10;
            t /= 10;
        }
        return r == x;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {121, 1231, 0, -121, 100};
        for (int i = 0; i < nums.length; i++) {
            System.out.println(s.isPalindrome(nums[i]));
        }
    }
}