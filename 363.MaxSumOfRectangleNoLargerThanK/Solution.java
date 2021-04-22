import java.util.*;

/**
 * 363. Max Sum of Rectangle No Larger Than K
 * Hard
 * 搞半天，暴力超时
 */
public class Solution {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int n = matrix.length, m = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {   // 枚举左边界
            int[] row = new int[n];     // 存储行求和
            for (int j = i; j < m; j++) {   // 枚举右边界
                for (int p = 0; p < n; p++) {  // 利用一侧边界不动，递增求行和
                    row[p] += matrix[p][j];
                }

                TreeSet<Integer> set = new TreeSet<>(); // 降维为一维数组求区间和小于k
                set.add(0);
                int sum = 0;
                for (int r : row) {
                    sum += r;
                    Integer ceiling = set.ceiling(sum - k);
                    if (ceiling != null) {
                        max = Math.max(max, sum - ceiling);
                        if (max == k) {
                            return k;
                        }
                    }
                    set.add(sum);
                }
            }
        }
        return max;
    }

    private int maxSum(int[][] matrix, int k, int row, int col) {
        int n = matrix.length, m = matrix[0].length, max = Integer.MIN_VALUE;
        int[] rowSums = new int[n], colSums = new int[m], sums = new int[m - col + 1];
        Arrays.fill(rowSums, 0);
        Arrays.fill(colSums, 0);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                colSums[j] += matrix[i][j];
                rowSums[i] += matrix[i][j];
                sums[0] += matrix[i][j];
            }
        }
        
        for (int i = 0; i <= n - row; i++) {
            for (int j = 0; j <= m - col; j++) {
                if (j != 0) {
                    sums[j] = sums[j - 1] - colSums[j - 1];
                    colSums[j + col - 1] = matrix[i][j + col - 1];
                    for (int ii = i + 1; ii < i + row; ii++) {
                        colSums[j + col - 1] += matrix[ii][j + col - 1];
                    }
                    sums[j] += colSums[j + col - 1];
                } else if (i != 0 && j == 0) {
                    sums[j] = sums[j] - rowSums[i - 1];
                    for (int jj = 0; jj < col; jj++) {
                        rowSums[i + row - 1] += matrix[i + row - 1][jj];
                        colSums[jj] += matrix[i + row - 1][jj] - matrix[i - 1][jj];
                    }
                    sums[j] += rowSums[i + row - 1];
                }
                if (sums[j] <= k) {
                    max = Math.max(max, sums[j]);
                }
                if (max == k) {
                    return k;
                }
            }
        }
        return max;
    }

    public int maxSumSubmatrix0(int[][] matrix, int k) {
        int n = matrix.length, m = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                max = Math.max(max, maxSum(matrix, k, i, j));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][][] matrix = { 
                { { 1, 0, 1 }, 
                { 0, -2, 3 } },
                { { 2, 2, -1 } },
                { { 2, 2, -1 } },
                {{27,5,-20,-9,1,26,1,12,7,-4,8,7,-1,5,8},{16,28,8,3,16,28,-10,-7,-5,-13,7,9,20,-9,26},{24,-14,20,23,25,-16,-15,8,8,-6,-14,-6,12,-19,-13},{28,13,-17,20,-3,-18,12,5,1,25,25,-14,22,17,12},{7,29,-12,5,-5,26,-5,10,-5,24,-9,-19,20,0,18},{-7,-11,-8,12,19,18,-15,17,7,-1,-11,-10,-1,25,17},{-3,-20,-20,-7,14,-12,22,1,-9,11,14,-16,-5,-12,14},{-20,-4,-17,3,3,-18,22,-13,-1,16,-11,29,17,-2,22},{23,-15,24,26,28,-13,10,18,-6,29,27,-19,-19,-8,0},{5,9,23,11,-4,-20,18,29,-6,-4,-11,21,-6,24,12},{13,16,0,-20,22,21,26,-3,15,14,26,17,19,20,-5},{15,1,22,-6,1,-9,0,21,12,27,5,8,8,18,-1},{15,29,13,6,-11,7,-6,27,22,18,22,-3,-9,20,14},{26,-6,12,-10,0,26,10,1,11,-10,-16,-18,29,8,-8},{-19,14,15,18,-10,24,-9,-7,-19,-14,23,23,17,-5,6}} 
        };
        int[] k = { 2, 3, 0, -100 };

        Solution s = new Solution();
        for (int i = 0; i < k.length; i++) {
            System.out.println(s.maxSumSubmatrix(matrix[i], k[i]));
        }
    }
}
