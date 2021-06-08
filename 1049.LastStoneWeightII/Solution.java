import java.util.*;

/**
 * 1049. Last Stone Weight II
 * Meidum
 */
public class Solution {

    public int lastStoneWeightII(int[] stones) {
        int n = stones.length, sum = Arrays.stream(stones).sum(), half = sum / 2;
        int[] neg = new int[half + 1];
        for (int i = 1; i <= n; i++) {
            int x = stones[i - 1];
            for (int j = half; j >= x ; j--) {
                neg[j] = Math.max(neg[j - x] + x, neg[j]);
            }
        }
        return Math.abs(sum - 2 * neg[half]);
    }

    public static void main(String[] args) {
        int[][] stones = { { 2, 7, 4, 1, 8, 1 }, { 31, 26, 33, 21, 40 }, { 1, 2 } };
        Solution s = new Solution();
        for (int i = 0; i < stones.length; i++) {
            System.out.println(s.lastStoneWeightII(stones[i]));
        }
    }
}
