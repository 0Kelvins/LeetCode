import java.util.Arrays;

/**
 * 321. Create Maximum Number
 * Hard
 */
public class Solution {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int e = Math.min(nums1.length, k);
        int s = k - Math.min(nums2.length, k);
        int[] max = new int[k];
        for (int i = s; i <= e; i++) {
            int[] m = maxMerge(maxNumber(nums1, i), maxNumber(nums2, k - i));
            if (compare(m, 0, max, 0) > 0) {
                max = m;
            }
        }
        return max;
    }

    private int[] maxNumber(int[] nums, int k) {
        int length = nums.length;
        int[] stack = new int[k];
        int top = -1;
        int remain = length - k;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            while (top >= 0 && stack[top] < num && remain > 0) {
                top--;
                remain--;
            }
            if (top < k - 1) {
                stack[++top] = num;
            } else {
                remain--;
            }
        }
        return stack;
    }

    private int[] maxMerge(int[] a, int[] b) {
        int n = a.length, m = b.length;
        if (n == 0) {
            return b;
        }
        if (m == 0) {
            return a;
        }
        int[] res = new int[n + m];
        int l = 0, r = 0;
        for (int i = 0; i < res.length; i++) {
            if (compare(a, l, b, r) > 0) {
                res[i] = a[l++];
            } else {
                res[i] = b[r++];
            }
        }
        return res;
    }

    private int compare(int[] a, int i, int[] b, int j) {
        int n = a.length, m = b.length;
        while (i < n && j < m) {
            int d = a[i] - b[j];
            if (d != 0) {
                return d;
            }
            i++;
            j++;
        }
        return (n - i) - (m - j);
    }

    public static void main(String[] args) {
        int[][] nums1 = { { 2, 5, 6, 4, 4, 0 }, { 3, 4, 6, 5 }, { 6, 7 }, { 3, 9 } };
        int[][] nums2 = { { 7, 3, 8, 0, 6, 5, 7, 6, 2 }, { 9, 1, 2, 5, 8, 3 }, { 6, 0, 4 }, { 8, 9 } };
        int[] k = { 15, 5, 5, 3 };
        Solution sol = new Solution();
        for (int i = 0; i < k.length; i++) {
            int[] r = sol.maxNumber(nums1[i], nums2[i], k[i]);
            System.out.println(Arrays.toString(r));
        }
    }
}
