/**
 * 258. Add Digits
 * Easy
 * 123 = 1*100 + 2*10 + 3 = 1*99 + 2*9 + (1 + 2 + 3)
 */
public class Solution {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
