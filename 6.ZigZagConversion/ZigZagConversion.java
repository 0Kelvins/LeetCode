class Solution {
    public static String convert(String s, int n) {
        StringBuilder r = new StringBuilder();
        int len = s.length();

        // numRows = 1
        if (n == 1) {
            return s;
        }

        for (int i = 0; i < n; i++) {
            if (i % (n - 1) == 0) {     // corner
                int t = i, j = 2*n - 2;
                while (t < len) {
                    r.append(s.charAt(t));
                    t += j;
                }
            }
            else {
                int t = i, j = 2*(n - i - 1), k = 2*n - 2;
                while (t < len) {
                    r.append(s.charAt(t));
                    if ((t + j) < len) {
                        r.append(s.charAt(t + j));
                    }
                    t += k;
                }
            }
        }

        return r.toString();
    }

    public static void main(String[] args) {
        String s1 = convert("PAYPALISHIRING", 3);
        System.out.println("s1:" + s1);
        if ("PAHNAPLSIIGYIR".equals(s1)) {
            System.out.println("s1, ac.");
        }
        String s2 = convert("ABCDEFGHIJKLMNO", 2);
        System.out.println("s2:" + s2);
        if ("ACEGIKMOBDFHJLN".equals(s1)) {
            System.out.println("s2, ac.");
        }
    }
}