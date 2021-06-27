/**
 * 274. H-Index
 * Medium
 */
public class Solution {

    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] cits = new int[n + 1];
        for (int c : citations) {
            cits[Math.min(n, c)]++;
        }
        int h = n;
        for (int c = cits[n]; h > c; c += cits[h]) {
            h--;
        }
        return h;
    }

    public static void main(String[] args) {
        int[][] citations = { { 3, 0, 6, 1, 5 }, { 1, 3, 1 } };
        Solution s = new Solution();
        for (int[] c : citations) {
            System.out.println(s.hIndex(c));
        }
    }
}
