import java.util.*;

/**
 * 210. Course Schedule II
 * Medium
 * BFS拓扑排序
 */
public class Solution {

    private void topology(int[] inDgree, List<List<Integer>> list, List<Integer> ans, int k) {
        if (k != -1) {
            inDgree[k] = -1;
            for (Integer j : list.get(k)) {
                inDgree[j]--;
            }
        }
        for (int i = 0; i < inDgree.length; i++) {
            if (inDgree[i] == 0) {
                topology(inDgree, list, ans, i);
                ans.add(i);
            }
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        int[] inDgree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        Arrays.fill(inDgree, 0);
        for (int[] pre : prerequisites) {
            list.get(pre[0]).add(pre[1]);
            inDgree[pre[1]]++;
        }
        List<Integer> ans = new ArrayList<>();
        topology(inDgree, list, ans, -1);
        if (ans.size() < numCourses) {
            return new int[0];
        }
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] numCourses = { 2, 4, 1,2 };
        int[][][] prerequisites = { { { 1, 0 } }, { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } }, {}, {{1,0},{0,1}} };
        Solution s = new Solution();
        for (int i = 0; i < numCourses.length; i++) {
            int[] ans = s.findOrder(numCourses[i], prerequisites[i]);
            for (int j : ans) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
