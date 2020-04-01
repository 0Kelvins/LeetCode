import java.io.*;
import java.util.*;

/**
 * 130. Surrounded Regions
 * 先把边界的O标记出来，然后遍历就行了，至于用DFS或者BFS，差距不大吧
 */
class Solution {
    private void mark(char[][] board, int[][] flag, int row, int col, int i, int j) {
        if (i < 0 || i == row || j < 0 || j == col)
            return;
        if (flag[i][j] == 0 && board[i][j] == 'O') {
            flag[i][j] = 1;
            mark(board, flag, row, col, i + 1, j);
            mark(board, flag, row, col, i - 1, j);
            mark(board, flag, row, col, i, j + 1);
            mark(board, flag, row, col, i, j - 1);
        }
    }

    public void solve(char[][] board) {
        int row = board.length;
        if (row == 0)
            return;
        int col = board[0].length;
        int[][] flag = new int[row][col];
        for (int i = 0; i < row; i++)
            mark(board, flag, row, col, i, 0);
        for (int j = 0; j < col; j++)
            mark(board, flag, row, col, 0, j);
        for (int i = 0; i < row; i++)
            mark(board, flag, row, col, i, col - 1);
        for (int j = 0; j < col; j++)
            mark(board, flag, row, col, row - 1, j);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O' && flag[i][j] != 1)
                    board[i][j] = 'X';
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        File f = new File("input.txt");
        Scanner scan = new Scanner(f);
        while (scan.hasNext()) {
            int row = scan.nextInt();
            int col = scan.nextInt();
            char[][] board = new char[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++)
                    board[i][j] = scan.next().charAt(0);
            }
            s.solve(board);
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++)
                    System.out.print(board[i][j] + " ");
                System.out.println();
            }
        }
        scan.close();
    }
}