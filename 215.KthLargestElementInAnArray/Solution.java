import java.util.PriorityQueue;

/**
 * 215. Kth Largest Element in an Array
 * Medium
 */
public class Solution {
    public int findKthLargestByHeap(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a, b) -> a - b);
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            minHeap.add(nums[i]);
            minHeap.poll();
        }
        return minHeap.peek();
    }

    private int quicksort(int[] nums, int start, int end) {
        int pivot = nums[start], i = start, j = end;
        while (i < j) {
            while (i < j && pivot <= nums[j]) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        return i;
    }

    private void partition(int[] nums, int start, int end, int k) {
        if (start >= end) {
            return;
        }
        int p = quicksort(nums, start, end);
        if (p == k) {
            return;
        }
        partition(nums, start, p - 1, k);
        partition(nums, p + 1, end, k);
    }

    public int findKthLargest(int[] nums, int k) {
        partition(nums, 0, nums.length - 1, nums.length - k);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        int[][] nums = { { 3, 2, 1, 5, 6, 4 }, { 3, 2, 3, 1, 2, 4, 5, 5, 6 } };
        int[] k = { 2, 4 };
        Solution s = new Solution();
        for (int i = 0; i < k.length; i++) {
            System.out.println(s.findKthLargest(nums[i], k[i]));
        }
    }
}
