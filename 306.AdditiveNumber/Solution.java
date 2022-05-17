/**
 * 306. Additive Number
 * Medium
 * 可以优化一下尝试方法，每一次加法都检查是否和原字符串一致
 */
public class Solution {

    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        if (len < 3)
            return false;
        long p, q;
        String m;
        for (int i = 1; i <= len / 2; i++) {
            p = Long.parseLong(num.substring(0, i));
            for (int j = 1; j <= len / 2; j++) {
                int t = i + j;
                q = Long.parseLong(num.substring(i, t));
                String sum = p + q + "";
                if (t + sum.length() > len)
                    break;
                m = num.substring(t, t + sum.length());
                if (sum.equals(m)) {
                    String prediect = tryAdditive(p, q, len);
                    if (prediect.equals(num)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private String tryAdditive(long p, long q, int len) {
        StringBuilder builder = new StringBuilder();
        builder.append(p);
        builder.append(q);
        while (builder.length() < len) {
            long t = p + q;
            builder.append(t);
            p = q;
            q = t;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String[] seqs = { "112358", "199100199", "2", "991100199" };
        Solution s = new Solution();
        for (String as : seqs) {
            System.out.println(s.isAdditiveNumber(as));
        }
    }
}
