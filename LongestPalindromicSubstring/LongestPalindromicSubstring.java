class Solution {
    // 可避免处理奇偶回文串区别
    public static String preProcess(String s) {
        String r = "^";
        for (int i = 0; i < s.length(); i++) {
            r += "#" + s.charAt(i);
        }
        r += "#$";
        return r;
    }

    public static String longestPalindrome(String s) {
        String t = preProcess(s);   // 预处理字符串，如"^#a#b#a#$"
        int n = t.length();
        int[] P = new int[n]; // 处理后字符串对应每个字符为中心的最长回文串半径（原回文串的长度）
        int center = 0, i_mirror = 0, right = 0;
        // 当前i所在回文串的中心，i的关于center的镜像下标，前一个回文串的右边界下标

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