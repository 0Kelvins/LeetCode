/**
 * 1011. Capacity To Ship Packages Within D Days
 * Medium
 * 范围找中间的临界点，就二分查找
 */
public class Solution {

    private int minDay(int[] weights, int capacity) {
        int d = 0, sum = 0;
        for (int w : weights) {
            if (w > capacity) {
                return Integer.MAX_VALUE;
            }
            sum += w;
            if (sum > capacity) {
                d++;
                sum = w;
            }
        }
        return d + 1;
    }

    public int shipWithinDays(int[] weights, int D) {
        int maxCapacity = 0, minCapacity = 0;
        for (int w : weights) {
            maxCapacity += w;
        }
        int mid, t;
        while (minCapacity < maxCapacity) {
            mid = (minCapacity + maxCapacity) / 2;
            t = minDay(weights, mid);
            // System.out.println(mid + " " + t);
            if (t <= D) {
                maxCapacity = mid;
            } else {
                minCapacity = mid + 1;
            }
        }
        return maxCapacity;
    }

    public static void main(String[] args) {
        int[][] weights = { { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, { 3, 2, 2, 4, 1, 4 }, { 1, 2, 3, 1, 1 } };
        int[] D = { 5, 3, 4 };
        Solution s = new Solution();
        for (int i = 0; i < D.length; i++) {
            System.out.println(s.shipWithinDays(weights[i], D[i]));
        }
    }
}
