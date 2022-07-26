/**
 * 329. Longest Increasing Path in a Matrix
 * Hard
 */
public class Solution {

    private int n, m;
    private static int[][] direct = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int longestIncreasingPath(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        int[][] memo = new int[n][m];
        int longest = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(matrix, i, j, memo);
                longest = Math.max(longest, memo[i][j]);
            }
        }
        return longest;
    }
    
    private void dfs(int[][] matrix, int i, int j, int[][] memo) {
        if (memo[i][j] == 0) {
            memo[i][j] = 1;
        } else {
            return;
        }
        for (int k = 0; k < 4; k++) {
            int[] d = direct[k];
            int p = i + d[0], q = j + d[1];
            if (p < 0 || p == n || q < 0 || q == m) {
                continue;
            }
            int t = matrix[p][q];
            if (t > matrix[i][j]) {
                if (memo[p][q] == 0) {
                    dfs(matrix, p, q, memo);
                }
                memo[i][j] = Math.max(memo[i][j], memo[p][q] + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[][][] matrixs = {
                { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } },
                { { 3, 4, 5 }, { 3, 2, 6 }, { 2, 2, 1 } },
                { { 1 } } };
        Solution sol = new Solution();
        for (int[][] m : matrixs) {
            System.out.println(sol.longestIncreasingPath(m));
        }
    }
}
