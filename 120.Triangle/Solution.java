import java.io.*;
import java.util.*;

/**
 * 120. Triangle
 * dfs是会超时的，利用前两道简单题的思路来解
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 0)
            return 0;
        int m = triangle.get(n - 1).size();
        if (m == 0)
            return 0;
        int[] dp = new int[m];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            List<Integer> row = triangle.get(i);
            int pre = Integer.MAX_VALUE, j, l;
            for (j = 0; j < row.size() - 1; j++) {
                l = pre;
                pre = dp[j];
                dp[j] = row.get(j) + Math.min(l, dp[j]);
            }
            dp[j] = row.get(j) + pre;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] < min)
                min = dp[i];
        }
        return min;
    }

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        File f = new File("input.txt");
        Scanner scan = new Scanner(f);
        while (scan.hasNext()) {
            String[] rows = scan.nextLine().split(" ");
            List<List<Integer>> triangle = new ArrayList<>();
            for (String r : rows) {
                List<Integer> t = new ArrayList<>();
                String[] nums = r.split(",");
                for (String n : nums)
                    t.add(Integer.parseInt(n));
                triangle.add(t);
            }
            System.out.println(s.minimumTotal(triangle));
        }
        scan.close();
    }
}