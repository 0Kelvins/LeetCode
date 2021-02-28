/**
 * 剑指 Offer 20. 表示数值的字符串
 * 这个小数点前后都可以省略就很离谱，想好状态怎么转移的是这题最麻烦的地方
 */
public class Solution {

    public boolean isNumber(String s) {
        if(s == null)
            return false;
        s = s.trim();
        if(s.length() == 0)
            return false;
        int n = s.length();
        boolean hasE = false, hasDot = false, preDigit = false;
        if (isSign(s.charAt(0))) {
            if (n == 1 || (n == 2 && isDot(s.charAt(1)))) {
                System.out.println("illeagal head sign");
                return false;
            }
        }
        else if (!isDigit(s.charAt(0))) { 
            if (!isDot(s.charAt(0)) || n < 2 || !isDigit(s.charAt(1))) {
                System.out.println("illeagal head");
                return false;
            }
            else {
                hasDot = true;
            }
        }
        else
            preDigit = true;

        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            if(isDigit(c)) {
                preDigit = true;
            } else {
                if (isSign(c)) {
                    if (!isE(s.charAt(i - 1)) || i == n - 1) {
                        System.out.println("illeagal sign");
                        return false;
                    }
                } else if(isE(c)) {
                    if ((!preDigit && !isDot(s.charAt(i - 1))) || hasE || i == n - 1) {
                        System.out.println("illeagal e");
                        return false;
                    }
                    else
                        hasE = true;
                } else if (isDot(c)) {
                    if (hasDot || hasE) {
                        System.out.println("illeagal dot");
                        return false;
                    }
                    else
                        hasDot = true;
                } else {
                    System.out.println("illeagal char");
                    return false;
                }
                preDigit = false;
            }
        }

        return true;
    }

    private boolean isSign(char c) {
        return c == '+' || c == '-';
    }

    private boolean isE(char c) {
        return c == 'E' || c == 'e';
    }

    private boolean isDigit(char c) {
        return c - '0' >= 0 && c - '0' < 10;
    }
    
    private boolean isDot(char c) {
        return c == '.';
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] in = {"+100", "5e2", "-123", "3.1416", "-1E-16", "0123", ".1", "1.e2",
                ".1.", "12e", "1a3.14", "1.2.3", "+-5", "12e+5.4", "46+3" };
        for (String i : in) {
            System.out.println(i + "\t " + s.isNumber(i));
        }
    }
}
