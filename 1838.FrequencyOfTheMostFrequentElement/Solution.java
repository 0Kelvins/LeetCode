import java.util.Arrays;

/**
 * 1838. Frequency of the Most Frequent Element
 * Medium
 * 排序+前缀和+滑动窗口
 */
public class Solution {

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int max = 1, j, count;
        for (int i = 1; i < n; i++) {
            j = i - max + 1;
            count = max;
            while (j >= 0) {
                int t = count * nums[i] - (sum[i + 1] - sum[j]);
                if (t > k) {
                    break;
                }
                max = Math.max(max, count);
                count++;
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] nums = { { 1, 2, 4 }, { 1, 4, 8, 13 }, { 3, 9, 6 } };
        int[] k = { 5, 5, 2 };
        Solution s = new Solution();
        for (int i = 0; i < k.length; i++) {
            System.out.println(s.maxFrequency(nums[i], k[i]));
        }
    }
}