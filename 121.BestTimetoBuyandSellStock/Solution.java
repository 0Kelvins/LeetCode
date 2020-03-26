import java.io.*;
import java.util.*;

/**
 * 121. Best Time to Buy and Sell Stock
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0)
            return 0;
        int min = prices[0], max = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] < min)
                min = prices[i];
            int p = prices[i] - min;
            if (p > max)
                max = p;
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        File f = new File("input.txt");
        Scanner scan = new Scanner(f);
        while (scan.hasNext()) {
            String[] nums = scan.nextLine().split(",");
            int[] prices = new int[nums.length];
            for (int i = 0; i < prices.length; i++)
                prices[i] = Integer.parseInt(nums[i]);
            System.out.println(s.maxProfit(prices));
        }
        scan.close();
    }
}