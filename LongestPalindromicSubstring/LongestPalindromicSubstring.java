class Solution {
    // �ɱ��⴦����ż���Ĵ�����
    public static String preProcess(String s) {
        String r = "^";
        for (int i = 0; i < s.length(); i++) {
            r += "#" + s.charAt(i);
        }
        r += "#$";
        return r;
    }

    public static String longestPalindrome(String s) {
        String t = preProcess(s);   // Ԥ�����ַ�������"^#a#b#a#$"
        int n = t.length();
        int[] P = new int[n]; // ������ַ�����Ӧÿ���ַ�Ϊ���ĵ�����Ĵ��뾶��ԭ���Ĵ��ĳ��ȣ�
        int center = 0, i_mirror = 0, right = 0;
        // ��ǰi���ڻ��Ĵ������ģ�i�Ĺ���center�ľ����±꣬ǰһ�����Ĵ����ұ߽��±�

        for (int i = 1; i < n - 1; i++) {
            i_mirror = 2*center - i;
            P[i] = i <= right ? Math.min(right - i, P[i_mirror]) : 0;

            while (t.charAt(i - P[i] - 1) == t.charAt(i + P[i] + 1)) {
                P[i]++;
            }

            if (i + P[i] > right) {
                right = i + P[i];
                center = i;
            }
        }

        int ml = 0, mc = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] > ml) {
                ml = P[i];
                mc = i;
            }
        }
        int startIndex = (mc - 1 - ml) / 2, endIndex = startIndex + ml;
        return s.substring(startIndex, endIndex);
    }

    public static void main(String[] args) {
        String s1 = longestPalindrome("aba");
        System.out.println(s1);
        String s2 = longestPalindrome("babad");
        System.out.println(s2);
        String s3 = longestPalindrome("abaaba");
        System.out.println(s3);
        String s4 = longestPalindrome("babcbabcbaccba");
        System.out.println(s4);
    }
}