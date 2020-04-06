/**
 * 135. Candy
 * 自己还是太菜了
 */
class Solution {
    private void fillPit(int[] ratings, int n, int i, int[] candys) {
        int l = i - 1, r = i + 1;
        candys[i] = 1;
        while (l >= 0 && ratings[l] >= ratings[l + 1]) {
            int t = ratings[l] == ratings[l + 1] ? 1 : candys[l + 1] + 1;
            candys[l] = Math.max(t, candys[l]);
            l--;
        }
        while (r < n && ratings[r] >= ratings[r - 1]) {
            int t = ratings[r] == ratings[r - 1] ? 1 : candys[r - 1] + 1;
            candys[r] = Math.max(t, candys[r]);
            r++;
        }
    }

    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int[] candys = new int[n];
        if (ratings[0] <= ratings[1]) {
            fillPit(ratings, n, 0, candys);
        }
        if (ratings[n - 2] >= ratings[n - 1]) {
            fillPit(ratings, n, n - 1, candys);
        }
        for (int i = 1; i < n - 1; i++) {
            if (ratings[i] <= ratings[i - 1] && ratings[i] <= ratings[i + 1]) {
                fillPit(ratings, n, i, candys);
            }
        }
        int total = 0;
        for (int i = 0; i < n; i++) {
            System.out.print(candys[i] + " ");
            total += candys[i];
        }
        return total;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] ratings = { { 1, 0, 2 }, { 1, 2, 2 }, { 1, 2, 3 }, { 3, 2, 1 }, { 2, 2, 2 }, { 1, 2, 87, 87, 87, 2, 1 },
                { 1, 3, 2, 2, 1 }, { 1, 6, 10, 8, 7, 3, 2 } };
        for (int i = 0; i < ratings.length; i++)
            System.out.println(s.candy(ratings[i]));
    }
}