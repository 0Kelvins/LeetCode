import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 310. Minimum Height Trees
 * Medium
 */
public class Solution {
    
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<Integer>();
        if (n == 1) {
            ans.add(0);
            return ans;
        }
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        /* find farthest point x to 0 */
        int x = findLongestNode(0, parent, adj);
        /* find farthest point y to x  */
        int y = findLongestNode(x, parent, adj);
        /* get path from x to y  */
        List<Integer> path = new ArrayList<Integer>();
        parent[x] = -1;
        while (y != -1) {
            path.add(y);
            y = parent[y];
        }
        int m = path.size();
        if (m % 2 == 0) {
            ans.add(path.get(m / 2 - 1));
        }
        ans.add(path.get(m / 2));
        return ans;
    }

    public int findLongestNode(int u, int[] parent, List<Integer>[] adj) {
        int n = adj.length;
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[u] = 0;
        dfs(u, dist, parent, adj);
        int maxdist = 0;
        int node = -1;
        for (int i = 0; i < n; i++) {
            if (dist[i] > maxdist) {
                maxdist = dist[i];
                node = i;
            }
        }
        return node;
    }

    public void dfs(int u, int[] dist, int[] parent, List<Integer>[] adj) {
        for (int v : adj[u]) {
            if (dist[v] < 0) {
                dist[v] = dist[u] + 1;
                parent[v] = u;
                dfs(v, dist, parent, adj); 
            }
        }
    }
    
    public static void main(String[] args) {
        int[] n = { 4, 6, 3, 6, 10 };
        int[][][] edges = { { { 1, 0 }, { 1, 2 }, { 1, 3 } },
                { { 3, 0 }, { 3, 1 }, { 3, 2 }, { 3, 4 }, { 5, 4 } },
                { { 1, 0 }, { 0, 2 } },
                { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 3, 4 }, { 4, 5 } },
                { { 0, 3 }, { 1, 3 }, { 2, 3 }, { 4, 3 }, { 5, 3 }, { 4, 6 }, { 4, 7 }, { 5, 8 }, { 5, 9 } }
             };
        Solution s = new Solution();
        for (int i = 0; i < n.length; i++) {
            System.out.println(s.findMinHeightTrees(n[i], edges[i]).toString());
        }
    }
}
