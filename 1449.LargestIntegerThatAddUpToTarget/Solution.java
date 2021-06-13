import java.util.Arrays;
import java.util.Collections;

/**
 * 1449. Form Largest Integer With Digits That Add up to Target
 * Hard
 */
public class Solution {
    public String largestNumber(int[] cost, int target) {
        String[] dp = new String[target + 1];
        dp[0] = "";
        for (int i = 1; i < 10; i++) {
            int c = cost[i - 1];
            for (int j = c; j <= target; j++) {
                if (dp[j - c] != null) {
                    String dp_add = i + dp[j - c];
                    if (dp[j] == null) {
                        dp[j] = dp_add;
                    } else {
                        if (dp_add.length() == dp[j].length()) {
                            dp[j] = dp_add.compareTo(dp[j]) > 0 ? dp_add : dp[j];
                        } else {
                            dp[j] = dp_add.length() > dp[j].length() ? dp_add : dp[j];
                        }
                    }
                }
            }
            // System.out.println("[ " + String.join(", ", dp) + " ]");
        }
        return dp[target] == null ? "0" : dp[target];
    }

    public static void main(String[] args) {
        int[][] cost = { { 4, 3, 2, 5, 6, 7, 2, 5, 5 }, { 7, 6, 5, 5, 5, 6, 8, 7, 8 }, { 2, 4, 6, 2, 4, 6, 4, 4, 4 },
                { 6, 10, 15, 40, 40, 40, 40, 40, 40 } };
        int[] target = { 9, 12, 5, 47 };
        Solution s = new Solution();
        for (int i = 0; i < target.length; i++) {
            System.out.println(s.largestNumber(cost[i], target[i]));
        }
    }
}
