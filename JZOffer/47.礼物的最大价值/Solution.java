/**
 * 47. 礼物的最大价值
 * Medium
 */
public class Solution {
    public int maxValue(int[][] grid) {
        int[] row = new int[grid[0].length + 1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                row[j + 1] = Math.max(row[j], row[j + 1]) + grid[i][j];
            }
        }
        return row[row.length - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][][] grids = {
            {
                { 1, 3, 1 },
                { 1, 5, 1 },
                { 4, 2, 1 }
            },
            {
                { 1, 3, 1 },
                { 1, 5, 1 },
                { 10, 2, 1 }
            }
        };
        for (int[][] g : grids) {
            System.out.println(s.maxValue(g));
        }
    }
}
