import java.util.*;
import java.io.*;

/**
 * 174. Dungeon Game
 * 简单DP
 */
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        if (row == 0)
            return 1;
        int col = dungeon[0].length;
        if (col == 0)
            return 1;
        int[] dp = new int[col + 1];
        for (int i = 0; i <= col; i++)
            dp[i] = Integer.MIN_VALUE;
        dp[col - 1] = 0;
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j + 1]) + dungeon[i][j];
                if (dp[j] > 0)
                    dp[j] = 0;
            }
        }
        return 1 - dp[0];
    }

    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        File f = new File("input.txt");
        Scanner scan = new Scanner(f);
        while (scan.hasNext()) {
            int row = scan.nextInt(), col = scan.nextInt();
            int[][] dungeon = new int[row][col];
            scan.nextLine();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++)
                    dungeon[i][j] = scan.nextInt();
                scan.nextLine();
            }
            System.out.println(s.calculateMinimumHP(dungeon));

        }
        scan.close();
    }
}