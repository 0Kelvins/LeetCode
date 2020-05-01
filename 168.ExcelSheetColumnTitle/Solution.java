/**
 * 168. Excel Sheet Column Title
 */
class Solution {
    public String convertToTitle(int n) {
        StringBuilder s = new StringBuilder();
        while (n != 0) {
            n--;
            s.insert(0, (char) ('A' + n % 26));
            n /= 26;
        }
        return s.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        for (int i = 1; i < 27; i++)
            System.out.print(i + ":" + s.convertToTitle(i) + " ");
        int[] in = { 27, 28, 701 };
        for (int i : in) {
            System.out.print(i + ":" + s.convertToTitle(i) + " ");
        }
    }
}