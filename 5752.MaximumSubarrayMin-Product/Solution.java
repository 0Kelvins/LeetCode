import java.util.Deque;
import java.util.LinkedList;

/**
 * 5752. Maximum Subarray Min-Product
 * Medium
 * 单调栈+不增前缀，这想不出来啊.
 */
public class Solution {

    public int maxSumMinProduct(int[] nums) {
        int mod = (int)1e9 + 7;
        long max = 0;
        Deque<Integer> stack = new LinkedList<>();
        long[] dp = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            long sum = 0;
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                int peek = stack.pop();
                sum += dp[peek]; // 比当前值大的元素
                max = Math.max(max, sum * nums[peek]);
                // System.out.println(sum + " " + nums[peek]);
            }
            dp[i] = sum + nums[i]; // 比当前值大的元素及当前元素的和
            stack.push(i);
        }
        long sum = 0;
        while (!stack.isEmpty()) {
            int peek = stack.pop();
            sum += dp[peek];
            max = Math.max(max, sum * nums[peek]);
            // System.out.println(sum + " " + nums[peek]);
        }

        return (int)(max % mod);
    }

    public static void main(String[] args) {
        int[][] nums = { { 1, 2, 3, 2 }, { 2, 3, 3, 1, 2 }, { 3, 1, 5, 6, 4, 2 } };
        Solution s = new Solution();
        for (int i = 0; i < nums.length; i++) {
            System.out.println(s.maxSumMinProduct(nums[i]));
        }
    }
}
