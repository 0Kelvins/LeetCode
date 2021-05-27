/**
 * 1869. Longer Contiguous Segments of Ones than Zeros
 * Easy
 */
public class Solution {
    public boolean checkZeroOnes(String s) {
        int maxOne = 0, maxZero = 0, t = 1;
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i), pre = s.charAt(i - 1);
            if (cur == pre) {
                t++;
            } else {
                if (pre == '1') {
                    maxOne = Math.max(maxOne, t);
                } else {
                    maxZero = Math.max(maxZero, t);
                }
                t = 1;
            }
        }
        if (s.charAt(s.length()-1) == '1') {
            maxOne = Math.max(maxOne, t);
        } else {
            maxZero = Math.max(maxZero, t);
        }
        return maxOne > maxZero;
    }
}
