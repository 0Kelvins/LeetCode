import java.util.*;

/**
 * 207. Course Schedule
 * Medium
 * 有点难，拓扑排序问题，本题稀疏图，邻接表更快
 */
public class Solution {

    private boolean dfs(int[][] matrix, int[] visited, int i) {
        if (visited[i] == 1)
            return false;
        if (visited[i] == -1)   // 已dfs无回路
            return true;
        visited[i] = 1;
        for (int j = 0; j < matrix[i].length; j++) {
            if (matrix[i][j] == 1 && !dfs(matrix, visited, j)) {
                return false;
            }
        }
        visited[i] = -1;
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses];
        for (int[] edge : prerequisites) {
            matrix[edge[0]][edge[1]] = 1;
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(matrix, visited, i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] numCourses = { 2, 2, 3 , 3 ,4};
        int[][][] prerequisites = { { { 1, 0 } }, { { 1, 0 }, { 0, 1 } },
                { { 1, 0 }, { 1, 2 }, { 0, 1 } }, { { 1, 2 }, { 0, 1 } },
                {{2,0},{1,0},{3,1},{3,2},{1,3}}
            };

        Solution s = new Solution();
        for (int i = 0; i < numCourses.length; i++) {
            System.out.println(s.canFinish(numCourses[i], prerequisites[i]));
        }
    }
}
