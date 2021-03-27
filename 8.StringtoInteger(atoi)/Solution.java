/**
 * 8. String to Integer (atoi)
 * Medium
 * 补一下，以前看点👎的人太多就没做，现在感觉题目很清楚，可能改过了吧，可以自动机，但是不用更简单
 */
public class Solution {

    private Long MAX_VALUE = Long.valueOf(Integer.MAX_VALUE);

    private int getCharType(char c) {
        if(c == '+' || c == '-')
            return 0;
        if (c - '0' < 10 && c - '0' >= 0)
            return 1;
        return -1;
    }

    public int myAtoi(String s) {
        if (s == null)
            return 0;
        int res = 0, sign = 1, i = 0;
        long t;
        s = s.trim();
        if (s.length() == 0)
            return 0;
        char[] cs = s.toCharArray();
        if (getCharType(cs[i]) == 0) {
            sign = cs[i++] == '+' ? 1 : -1;
        }
        for (; i < cs.length; i++) {
            if (getCharType(cs[i]) == 1) {
                t = Long.valueOf(res) * 10l + (cs[i] - '0');
                if ((sign == 1 && t >= MAX_VALUE) || (sign == -1 && t >= MAX_VALUE + 1)) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                res = (int) t;
            } else {
                break;
            }
        }
        return sign * res;
    }

    public static void main(String[] args) {
        String[] in = { "042", "   -42", "4193 with words", "words and 987", "-91283472332", "2147483646" };
        Solution sol = new Solution();
        for (String s : in) {
            System.out.println(sol.myAtoi(s));
        }
    }
}