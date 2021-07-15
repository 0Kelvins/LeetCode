import java.util.*;

/**
 * 1846. Maximum Element After Decreasing and Rearranging
 * Medium
 */
public class Solution {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length, pre = 0, max = 0;
        Arrays.sort(arr);
        for (int i : arr) {
            pre = i > pre ? pre + 1 : pre;
            max = Math.max(pre, max);
        }
        return Math.min(n, max);
    }

    public static void main(String[] args) {
        int[][] arrs = { { 2, 2, 1, 2, 1 }, { 100, 1, 1000 }, { 1, 2, 3, 4, 5 }, { 1, 2, 2, 2, 5 } };
        Solution s = new Solution();
        for (int[] arr : arrs) {
            System.out.println(s.maximumElementAfterDecrementingAndRearranging(arr));
        }
    }
}