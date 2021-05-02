import java.io.*;

/**
 * 221. Maximal Square
 * Medium
 * 用的85题的降维的方法，这题DP更简单。
 */
public class Solution {

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] height = new int[n];
        int max = 0, width;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                height[j] = matrix[i][j] == '1' ? height[j] + 1 : 0;
            }
            int j = 0;
            while (j < n) {
                width = 0;
                int k = j, right = j + height[j], minHeight = height[j];
                while (k < right && k < n) {
                    if (height[k] < minHeight) {
                        j = k;
                        minHeight = height[j];
                    }
                    if (minHeight <= width) {
                        break;
                    } else {
                        width++;
                    }
                    k++;
                }
                max = Math.max(max, width);
                j++;
            }
        }
        return max * max;
    }

    public static void main(String[] args) throws IOException {
        // char[][][] matrixs = {
        //     {{'0','0','0','1','1'},
        //     {'1','1','0','1','1'},
        //     {'1','1','1','1','1'},
        //     {'1','1','1','1','1'},
        //     {'1','1','1','1','1'},
        //     {'0','1','1','1','1'}},
        //     {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}},
        //     {{'0','1'},{'1','0'}},
        //     {{'1'}}
        // };
        // Solution s = new Solution();
        // for (char[][] m : matrixs) {
        //     System.out.println(s.maximalSquare(m));
        // }

        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(new FileInputStream("input.txt"))));
        st.nextToken();
        int m = (int) st.nval;
        st.nextToken();
        int n = (int) st.nval;
        char[][] matrix = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                st.nextToken();
                matrix[i][j] = st.nval == 1 ? '1' : '0';
            }
        }
        Solution s = new Solution();
        System.out.println(s.maximalSquare(matrix));
    }
}
