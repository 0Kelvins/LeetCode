import java.util.*;

/**
 * 871. Minimum Number of Refueling Stops
 * hard
 * DP时间复杂度O(N^2)，可以使用大顶堆优化至O(N·logN)
*/
class Solution {
    public int minRefuelStopsDP(int target, int startFuel, int[][] stations) {
        int snum = stations.length;
        long[] dp = new long[snum+1];
        dp[0] = startFuel;
        for (int i = 0; i < snum; i++) {
            for (int t = i; t >= 0; t--) {
                if (dp[t] >= stations[i][0])
                    dp[t+1] = Math.max(dp[t+1], (long)stations[i][1] + dp[t]);
            }
        }
        for (int i = 0; i <= snum; i++) {
            if (dp[i] >= target) return i;
        }
        return -1;
    }

    public int minRefuelStops(int target, int tank, int[][] stations) {
        // 优先队列是一个加油站容量的大顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int ans = 0, prev = 0;
        for (int[] station: stations) {
            int location = station[0];
            int capacity = station[1];
            tank -= location - prev;
            while (!pq.isEmpty() && tank < 0) {  // 必须在之前加油
                tank += pq.poll();
                ans++;
            }

            if (tank < 0) return -1;
            pq.offer(capacity);
            prev = location;
        }

        // 局部代码块，终点station={target, infinite}
        {
            tank -= target - prev;
            while (!pq.isEmpty() && tank < 0) {
                tank += pq.poll();
                ans++;
            }
            if (tank < 0) return -1;
        }

        return ans;
    }

    public static void main(String[] args) {
        int target = 100, startFuel = 10;
        int[][] stations = {{10,60},{20,30},{30,30},{60,40}};
        Solution solution = new Solution();
        System.out.println(solution.minRefuelStops(target, startFuel, stations));
    }
}