/**
 * 1870. Minimum Speed to Arrive on Time
 * Medium
 * 二分查找，思路没错，太久没写有点乱，边界直接最大最小值比遍历一遍更快，应该因为case数组会很大的原因吧。
 */
public class Solution {
    private double timeCost(int[] dist, int speed) {
        double time = 0;
        int n = dist.length, t = 0;
        for (int i = 0; i < n - 1; i++) {
            t += Math.ceil((double) dist[i] / speed);
        }
        time = (double) t + (double) dist[n - 1] / speed;
        return time;
    }

    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        if(hour <= n - 1) {
            return -1;
        }
        int totalDistance = 0, maxDistance = 0;
        for (int d : dist) {
            totalDistance += d;
            maxDistance = Math.max(maxDistance, d);
        }

        int maxSpeed = Math.max(maxDistance, (int) Math.ceil(dist[n - 1] / (hour - n + 1))); // maxDistance / 1.0
        if(timeCost(dist, maxSpeed) > hour) {
            return -1;
        }
        int minSpeed = Math.max(1, (int) (totalDistance / hour));
        while (minSpeed < maxSpeed) {
            int mid = minSpeed + (maxSpeed - minSpeed) / 2;
            Double midTime = timeCost(dist, mid);
            if (midTime <= hour) {
                maxSpeed = mid;
            } else {
                minSpeed = mid + 1;
            }
        }
        return minSpeed;
    }

    public static void main(String[] args) {
        int[][] dist = { { 1, 3, 2 }, { 1, 3, 2 }, { 1, 3, 2 }, { 1, 3, 2 }, { 1, 3, 2 },
                { 2, 1, 5, 4, 4, 3, 2, 9, 2, 10 } };
        double[] hour = { 6, 2.7, 1.9, 2.1, 4, 75.12 };
        Solution s = new Solution();
        for (int i = 0; i < hour.length; i++) {
            System.out.println(s.minSpeedOnTime(dist[i], hour[i]));
        }
    }
}
