/**
 * 1872. Stone Game VIII
 * Hard
 */
public class Solution {

    private int dfs(int[] pre, Integer[] maxDis, int i) {
        if (maxDis[i] != null) {
            return maxDis[i];
        }
        // maxDis[i] = max(maxDis[i+1], pre[i]-maxDis[i+1]), a = max(a, pre-b)
        int max = Math.max(dfs(pre, maxDis, i + 1), pre[i] - dfs(pre, maxDis, i + 1));
        return maxDis[i] = max;
    }

    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int[] pre = new int[n+1];
        pre[0] = 0;
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + stones[i];
        }

        Integer[] maxDis = new Integer[n + 1];
        maxDis[n] = pre[n];
        return dfs(pre, maxDis, 2);
    }

    public static void main(String[] args) {
        int[][] stones = { { -1, 2, -3, 4, -5 }, { 7, -6, 5, 10, 5, -2, -6 }, { -10, -12 } };
        Solution s = new Solution();
        for (int[] stone : stones) {
            System.out.println(s.stoneGameVIII(stone));
        }
    }
}
