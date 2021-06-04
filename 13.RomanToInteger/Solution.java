/**
 * 13. Roman to Integer
 * Easy
 */
public class Solution {

    private int transfer(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return -1;
        }
    }

    public int romanToInt(String s) {
        char[] sc = s.toCharArray();
        int num = 0, len = sc.length - 1, pre = 0;
        for (int i = len; i >= 0; i--) {
            int t = transfer(sc[i]);
            if (t >= pre) {
                num += t;
            } else {
                num -= t;
            }
            pre = t;
        }
        return num;
    }

    public static void main(String[] args) {
        String[] strs = { "III", "IV", "IX", "LVIII", "MCMXCIV" };
        Solution sol = new Solution();
        for (String s : strs) {
            System.out.println(sol.romanToInt(s));
        }
    }
}