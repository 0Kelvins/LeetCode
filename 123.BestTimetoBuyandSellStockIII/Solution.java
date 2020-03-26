import java.io.*;
import java.util.*;

/**
 * 123. Best Time to Buy and Sell Stock III
 * 前两题挺简单的，这题暴力拆成两部分用I的方法也可以过，但是效率肯定就很低了
 * 限制两次交易，把第一次的盈利作为第二次的买入资金，即可用第二次的盈利算出结果
 */
class Solution {
    public int maxProfit(int[] prices) {
        int buy_1 = Integer.MAX_VALUE, sell_1 = 0, buy_2 = Integer.MAX_VALUE, sell_2 = 0;
        for (int p : prices) {
            buy_1 = Math.min(buy_1, p);
            sell_1 = Math.max(sell_1, p - buy_1);
            buy_2 = Math.min(buy_2, p - sell_1); // 把第一次的盈利作为第二次的买入资金
            sell_2 = Math.max(sell_2, p - buy_2);
        }
        return sell_2;
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