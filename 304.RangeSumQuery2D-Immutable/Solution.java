import java.util.Arrays;

/**
 * 304. Range Sum Query 2D - Immutable
 * Medium
 */
class NumMatrix {

    private int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        sumMatrix = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sumMatrix[i + 1][j + 1] = sumMatrix[i][j + 1] + sumMatrix[i + 1][j] - sumMatrix[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumMatrix[row2 + 1][col2 + 1] - sumMatrix[row1][col2 + 1]
             - sumMatrix[row2 + 1][col1] + sumMatrix[row1][col1];
    }
}

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = { { 3, 0, 1, 4, 2 },
                            { 5, 6, 3, 2, 1 }, 
                            { 1, 2, 0, 1, 5 }, 
                            { 4, 1, 0, 1, 7 },
                            { 1, 0, 3, 0, 5 } };
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3)); // return 8 (i.e sum of the red rectangle)
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2)); // return 11 (i.e sum of the green rectangle)
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4)); // return 12 (i.e sum of the blue rectangle)
    }
}
