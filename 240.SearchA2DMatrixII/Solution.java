/**
 * 240. Search a 2D Matrix II
 * Medium
 * 使用了范围缩小的方法，可以使用递归来简化代码（官方题解三）
 * 官方题解四从左下角进行遍历的方法，像二分查找树一样一个方向小一个方向大，进行比较搜索
 */
public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0)
            return false;
        int m = matrix[0].length;

        int min_i = 0, max_i = n - 1, min_j = 0, max_j = m - 1, i, j;
        while (min_i < max_i || min_j < max_j) {
            for (i = max_i; i >= min_i; i--) {
                if (target < matrix[i][min_j])
                    max_i = i - 1;
                else
                    break;
            }
            if (min_i > max_i)
                return false;
            for (i = min_i; i <= max_i; i++) {
                if (target > matrix[i][max_j])
                    min_i = i + 1;
                else
                    break;
            }
            if (min_i > max_i)
                return false;
            for (j = max_j; j >= min_j; j--) {
                if (target < matrix[min_i][j])
                    max_j = j - 1;
                else
                    break;
            }
            if (min_j > max_j)
                return false;
            for (j = min_j; j <= max_j; j++) {
                if (target > matrix[max_i][j])
                    min_j = j + 1;
                else
                    break;
            }
            if (min_j > max_j)
                return false;
            if (target == matrix[min_i][min_j] || target == matrix[min_i][max_j])
                return true;
        }
        if (target == matrix[min_i][min_j] || target == matrix[min_i][max_j])
            return true;
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][][] matrixs = {
                { 
                    { 1, 4, 7, 11, 15 },
                    { 2, 5, 8, 12, 19 }, 
                    { 3, 6, 9, 16, 22 }, 
                    { 10, 13, 14, 17, 24 },
                    { 18, 21, 23, 26, 30 } 
                },
                {
                    {1, 1}
                },
                {
                    {-5}
                },
                {
                    { 5, 6, 9 }, 
                    { 9, 10, 11 }, 
                    { 11, 14, 18 }
                } 
        };
        int[][] targets = { { 5, 20 }, {1, 2}, {-5, 5}, {9} };
        for (int i = 0; i < targets.length; i++) {
            for (int j = 0; j < targets[i].length; j++) {
                System.out.println(s.searchMatrix(matrixs[i], targets[i][j]));
            }
        }
    }
}
