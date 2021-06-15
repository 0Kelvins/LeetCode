/**
 * 1899. Merge Triplets to Form Target Triplet
 * Meidum
 */
public class Solution {

    private boolean isSmaller(int[] a, int[] b) {
        for (int i = 0; i < b.length; i++) {
            if (a[i] > b[i]) {
                return false;
            }
        }
        return true;
    }
    
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] t = new int[3];
        for (int i = 0; i < triplets.length; i++) {
            if (isSmaller(triplets[i], target)) {
                for (int j = 0; j < t.length; j++) {
                    t[j] = Math.max(t[j], triplets[i][j]);
                }
            }
        }
        for (int i = 0; i < t.length; i++) {
            if (t[i] != target[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][][] triplets = { { { 2, 5, 3 }, { 1, 8, 4 }, { 1, 7, 5 } },
                               { { 1, 3, 4 }, { 2, 5, 8 } },
                               { { 2, 5, 3 }, { 2, 3, 4 }, { 1, 2, 5 }, { 5, 2, 3 } },
                               { { 3, 4, 5 }, { 4, 5, 6 } } };
        int[][] target = { { 2, 7, 5 }, { 2, 5, 8 }, { 5, 5, 5 }, { 3, 2, 5 } };
        Solution s = new Solution();
        for (int i = 0; i < target.length; i++) {
            System.out.println(s.mergeTriplets(triplets[i], target[i]));
        }
    }
}
