import java.util.*;

/**
 * 909. Snakes and Ladders
 * Medium
 * BFS
 * 752/773
 */
public class Solution {

    private int getPositionValue(int[][] board, int pos) {
        int n = board.length;
        int i = (pos - 1) / n, j = (pos - 1) % n;
        j = i % 2 == 0 ? j : (n - 1 - j);
        // System.out.println(Arrays.asList(pos, board[n - 1 - i][j], n - 1 - i, j));
        return board[n - 1 - i][j];
    }

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(1);
        Set<Integer> visited = new HashSet<>();
        visited.add(1);
        int moves = 0, target = n * n;
        while (!queue.isEmpty()) {
            moves++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int pos = queue.poll();
                for (int j = pos + 1; j <= pos + 6; j++) {
                    if (j > target) {
                        break;
                    }
                    int dis = getPositionValue(board, j);
                    if (dis == -1) {
                        dis = j;
                    }
                    if (dis == target) {
                        return moves;
                    }
                    if (!visited.contains(dis)) {
                        queue.offer(dis);
                        visited.add(dis);
                    }
                }
            }
            System.out.println();
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] board = {
            {-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,35,-1,-1,13,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,15,-1,-1,-1,-1}};
        Solution s = new Solution();
        System.out.println(s.snakesAndLadders(board));
    }
    
}
