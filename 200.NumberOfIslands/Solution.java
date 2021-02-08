/**
 * 200. Number of Islands
 * Medium
 * 这题用的DFS，没有太注意时间和空间占用
 */
public class Solution {

    private boolean isWater(char[][] grid, int i, int j) {
        return i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0';
    }

    private boolean exploreLand(char[][] grid, int i, int j, int[][] flag) {
        int[][] ds = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } }; // directions
        if (!isWater(grid, i, j) && flag[i][j] == 0) {
            flag[i][j] = 1;
            for (int d = 0; d < 4; d++) {
                exploreLand(grid, i + ds[d][0], j + ds[d][1], flag);
            }
            return true;
        }
        return false;
    }

    public int numIslands(char[][] grid) {
        int n = 0, row = grid.length;
        if(row == 0) 
            return 0;
        int col = grid[0].length;
        int[][] flag = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == '1' && exploreLand(grid, i, j, flag)) 
                    n++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][][] grids = { {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        }, {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        }, {
            {'1'}
        }, {
            {'0'}
        } };
        
        for (char[][] grid : grids) {
            System.out.println(s.numIslands(grid));
        }
    }
}
