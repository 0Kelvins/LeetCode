import java.util.*;

/**
 * 743. Network Delay Time
 * Medium
 * Dijkstra：BFS+递归更新最短时间
 */
public class Solution {

    private void updateDistance(int[][] matrix, int n, int[] dis, int cur, int newDis) {
        if (newDis < dis[cur]) {
            dis[cur] = newDis;
            for (int i = 1; i <= n; i++) {
                if (matrix[cur][i] >= 0) {
                    updateDistance(matrix, n, dis, i, newDis + matrix[cur][i]);
                }
            }
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] matrix = new int[n + 1][n + 1];
        Arrays.stream(matrix).forEach((m) -> Arrays.fill(m, -1));
        Arrays.stream(times).forEach((t) -> matrix[t[0]][t[1]] = t[2]);
        int[] visited = new int[n + 1];
        Arrays.fill(visited, -1);
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(k);
        visited[k] = 0;
        while (!queue.isEmpty()) {
            int c = queue.poll();
            for (int i = 1; i <= n; i++) {
                if (matrix[c][i] >= 0) {
                    int t = visited[c] + matrix[c][i];
                    if (visited[i] == -1) {
                        queue.offer(i);
                        visited[i] = t;
                    } else {
                        updateDistance(matrix, n, visited, i, t);
                        // 这里也可以重新入队进行更新
                    }
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i] == -1) {
                return -1;
            }
            maxTime = Math.max(visited[i], maxTime);
        }
        return maxTime;
    }

    public static void main(String[] args) {
        int[][][] times = { { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } }, { { 1, 2, 1 } }, { { 1, 2, 1 } }, 
        {{4,2,76},{1,3,79},{3,1,81},{4,3,30},{2,1,47},{1,5,61},{1,4,99},{3,4,68},{3,5,46},{4,1,6},{5,4,7},{5,3,44},{4,5,19},{2,3,13},{3,2,18},{1,2,0},{5,1,25},{2,5,58},{2,4,77},{5,2,74}} };
        int[] n = { 4, 2, 2,5 };
        int[] k = { 2, 1, 2,3 };
        Solution s = new Solution();
        for (int i = 0; i < k.length; i++) {
            System.out.println(s.networkDelayTime(times[i], n[i], k[i]));
        }
    }
}
