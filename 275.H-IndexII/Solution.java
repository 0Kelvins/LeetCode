/**
 * 275. H-Index II
 * Medium
 */
public class Solution {

    public int hIndex(int[] citations) {
        int n = citations.length, l = 0, r = n;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (n - m > citations[m]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return n - l;
    }

    public static void main(String[] args) {
        int[][] citations = { { 0, 1, 3, 5, 6 }, { 1, 2, 100 }, {0} };
        Solution s = new Solution();
        for (int[] c : citations) {
            System.out.println(s.hIndex(c));
        }
    }
}