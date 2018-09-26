/**
 * 7. Reverse Integer
 * easy
 * 记录：边界值！！！！！看全题目啊喂！！！！！！
 */
class Solution {
    public int reverse(int x) {
        int r = 0, max = Integer.MAX_VALUE / 10, min = Integer.MIN_VALUE / 10;
        while(x != 0) {
            if (r > max || r < min)
                return 0;
            r = r * 10 + x % 10;
            x /= 10;
        }
        return r;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverse(-123));
        System.out.println(s.reverse(0));
        System.out.println(s.reverse(120));
        System.out.println(s.reverse(1534236469));
        System.out.println(s.reverse(-2147483412));
    }
}