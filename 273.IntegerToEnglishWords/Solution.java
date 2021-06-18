import java.util.*;

/**
 * 273. Integer to English Words
 * Hard
 * 就是很碎
 */
public class Solution {
    private static String[] dict = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty" };
    private Map<Integer, String> map;
    
    Solution() {
        map = new HashMap<>();
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
        map.put(100, "Hundred");
        map.put(1000, "Thousand");
        map.put(1000000, "Million");
        map.put(1000000000, "Billion");
    }

    private String transfer(int n) {
        if (n < 21) {
            return dict[n];
        } else if (map.containsKey(n)) {
            return map.get(n);
        }
        return "err";
    }

    private void stringInsert(StringBuffer s, int n) {
        s.insert(0, " ");
        s.insert(0, transfer(n));
    }

    public String numberToWords(int num) {
        if (num == 0) {
            return transfer(num);
        }
        StringBuffer ans = new StringBuffer();
        int part, t, q = 1000;
        while (num > 0) {
            part = num % 1000;
            t = part % 100;
            if (t > 20 && t % 10 != 0) {
                t = part % 10;
                stringInsert(ans, t);
                t = part / 10;
                t = t % 10 * 10;
                stringInsert(ans, t);
            } else if (t > 0) {
                t = part % 100;
                stringInsert(ans, t);
            }
            if (part >= 100) {
                stringInsert(ans, 100);
                t = part / 100 % 10;
                stringInsert(ans, t);
            }
            num /= 1000;
            if (num > 0 && num % 1000 != 0) {
                stringInsert(ans, q);
            }
            q *= 1000;
        }
        return ans.toString().trim();
    }

    public static void main(String[] args) {
        int[] nums = { 123, 12345, 1234567, 1234567891, 118, 30, 100, 1000, 10000, 1000000 };
        Solution s = new Solution();
        for (int num : nums) {
            System.out.println("\"" + s.numberToWords(num) + "\"");
            System.out.println();
        }
    }
}
