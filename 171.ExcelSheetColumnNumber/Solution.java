/**
 * 171. Excel Sheet Column Number
 */
class Solution {
    public int titleToNumber(String s) {
        int r = 0;
        for (int i = s.length() - 1, j = 0; i >= 0; i--, j++)
            r += (s.charAt(i) - 'A' + 1) * Math.pow(26, j);
        return r;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] in = { "A", "AB", "ZY", "Z", "AA" };
        for (String i : in) {
            System.out.println(s.titleToNumber(i));
        }
    }
}