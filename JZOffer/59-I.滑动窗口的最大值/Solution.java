import java.util.*;

/**
 * 59 - I. 滑动窗口的最大值
 * Easy?
 * 单调队列的管理，窗口最大值会是哪些是核心问题
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0)
            return new int[0];
        Deque<Integer> q = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            while (!q.isEmpty() && q.peekLast() < nums[i]) {
                q.removeLast();    // 比当前值小的都可以移除，窗口内最大值不会是这些移除的值
            }
            q.addLast(nums[i]);
        }
        res[0] = q.getFirst();
        for (int i = k, j = 1; i < nums.length; i++, j++) {
            if (q.getFirst() == nums[i - k])    // 最大值滑出窗口
                q.removeFirst();
            while (!q.isEmpty() && q.peekLast() < nums[i]) {
                q.removeLast();
            }
            q.addLast(nums[i]);
            res[j] = q.getFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] nums = { { 1, 3, -1, -3, 5, 3, 6, 7 }, {}, {1, -1} };
        int[] k = { 3, 0, 1 };
        for (int i = 0; i < k.length; i++) {
            int[] res = sol.maxSlidingWindow(nums[i], k[i]);
            for (int r : res)
                System.out.print(r + " ");
            System.out.println();
        }
    }
}
