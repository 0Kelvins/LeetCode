import java.util.*;

/**
 * 239. Sliding Window Maximum
 * Hard--
 * 滑动（窗口）<-->单调栈（队列）
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (!queue.isEmpty() && queue.getLast() < nums[i]) {
                queue.removeLast();
            }
            queue.offer(nums[i]);
            // System.out.println(queue.getLast());
            if (i >= k - 1) {
                ans[j++] = queue.getFirst();
                if (queue.getFirst() == nums[i - k + 1]) {
                    queue.removeFirst();
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] nums = { { 1, 3, -1, -3, 5, 3, 6, 7 }, { 1 }, { 1, -1 }, { 9, 11 }, { 4, -2 } };
        int[] k = { 3, 1, 1, 2, 2 };
        Solution s = new Solution();
        for (int i = 0; i < k.length; i++) {
            System.out.println(Arrays.toString(s.maxSlidingWindow(nums[i], k[i])));
        }
    }
}
