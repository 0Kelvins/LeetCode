import java.util.Arrays;

/**
 * 1744. Can You Eat Your Favorite Candy on Your Favorite Day?
 * Meidum
 * queries[i] = [favoriteTypei, favoriteDayi, dailyCapi]
 * 边界比较
 */
public class Solution {

    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length, m = queries.length;
        long[] candiesSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            candiesSum[i] = candiesSum[i - 1] + candiesCount[i - 1];
        }
        boolean[] canOrNot = new boolean[m];
        for (int i = 0; i < m; i++) {
            int type = queries[i][0], day = queries[i][1] + 1, dailyCap = queries[i][2];
            if (candiesSum[type] / dailyCap < day && candiesSum[type + 1] >= day) {
                canOrNot[i] = true;
            } else {
                canOrNot[i] = false;
            }
        }
        return canOrNot;
    }

    public static void main(String[] args) {
        int[][] candiesCount = { { 7, 4, 5, 3, 8 }, { 5, 2, 6, 4, 1 }};

        int[][][] queries = { { { 0, 2, 2 }, { 4, 2, 4 }, { 2, 13, 1000000000 } },
                { { 3, 1, 2 }, { 4, 10, 3 }, { 3, 10, 100 }, { 4, 100, 30 }, { 1, 3, 1 } }};
        Solution s = new Solution();
        for (int i = 0; i < queries.length; i++) {
            System.out.println(Arrays.toString(s.canEat(candiesCount[i], queries[i])));
        }
    }
}