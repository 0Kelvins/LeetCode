/**
 * 67. Add Binary
 * Easy
 */
public class Solution {
    public String addBinary(String a, String b) {
        int n = a.length(), m = b.length(), carry = 0;
        StringBuilder builder = new StringBuilder();
        int i = 1;
        for (; (n - i >= 0) && (m - i >= 0); i++) {
            int an = a.charAt(n - i) - '0', bn = b.charAt(m - i) - '0';
            int t = an + bn + carry;
            carry = t / 2;
            t %= 2;
            builder.append(t);
        }
        if (n > m) {
            while (n - i >= 0) {
                int an = a.charAt(n - i++) - '0';
                int t = an + carry;
                carry = t / 2;
                t %= 2;
                builder.append(t);
            }
        } else {
            while (m - i >= 0) {
                int bn = b.charAt(m - i++) - '0';
                int t = bn + carry;
                carry = t / 2;
                t %= 2;
                builder.append(t);
            }
        }
        if (carry == 1) {
            builder.append('1');
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        String[] a = { "11", "1010" }, b = { "1", "1011" };
        Solution s = new Solution();
        for (int i = 0; i < b.length; i++) {
            System.out.println(s.addBinary(a[i], b[i]));
        }
    }
}
