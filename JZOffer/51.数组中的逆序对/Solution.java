import java.util.*;

/**
 * 剑指 Offer 51. 数组中的逆序对
 * Hard
 * 这题我用的暴力+二分优化，归并看了下，树状数组稍微了解了一下
 */
public class Solution {

    // 归并排序，O(nlogn)
    public int reversePairs(int[] nums) {
        int n = nums.length;
        if(n < 2)
            return 0;
        int[] copy = Arrays.copyOf(nums, n);
        int[] tmp = new int[n];
        return split(copy, 0, nums.length - 1, tmp);
    }

    private int split(int[] nums, int left, int right, int[] tmp) {
        if (left == right)
            return 0;

        int mid = left + (right - left) / 2;
        int leftPairs = split(nums, left, mid, tmp);
        int rightPairs = split(nums, mid + 1, right, tmp);

        if (nums[mid] <= nums[mid + 1]) // 左侧数组都比右侧小
            return leftPairs + rightPairs;

        int crossPairs = merger(nums, left, mid, right, tmp); // 有逆序，归并排序
        return leftPairs + rightPairs + crossPairs;
    }

    private int merger(int[] nums, int left, int mid, int right, int[] tmp) {
        for (int i = left; i <= right; i++)
            tmp[i] = nums[i];

        int count = 0;
        int p = left, q = mid + 1;
        for (int i = left; i <= right; i++) {
            if (p == mid + 1) // 左数组遍历完
                nums[i] = tmp[q++];
            else if(q == right + 1) // 右数组遍历完
                nums[i] = tmp[p++];
            else if(tmp[p] <= tmp[q]) // 左边比右边小或相等，包含相等，保证顺序
                nums[i] = tmp[p++];
            else {  // 左边比右边大
                nums[i] = tmp[q++];
                count += (mid - p + 1); //逆序数
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] in = { { 7, 5, 6, 4 }, { 1 }, { 7, 5, 6, 4, 3 } };
        for (int[] nums : in) {
            System.out.println(sol.reversePairs(nums));
        }
    }
}
