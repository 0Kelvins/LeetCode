/**
 * 38. Count and Say
 * Medium
 */
public class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String s = countAndSay(n - 1);
        StringBuilder builder = new StringBuilder();
        int count = 1, num, pre = -1;
        for (char c : s.toCharArray()) {
            num = c - '0';
            if (num == pre) {
                count++;
            } else {
                if (pre != -1) {
                    builder.append(count);
                    builder.append(pre);
                }
                count = 1;
                pre = num;
            }
        }
        if (pre != -1) {
            builder.append(count);
            builder.append(pre);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        int[] nums = { 1, 4, 5 };
        Solution s = new Solution();
        for (int n : nums) {
            System.out.println(s.countAndSay(n));
        }
    }
}
