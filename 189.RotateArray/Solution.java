/**
 * 189. Rotate Array
 * Medium
 * 考研题。其他方法较简单
 */
public class Solution {

    private void rIndex(int[] nums, int s, int e) {
        int m = (e - s + 1) / 2, t;
        for (int i = 0; i < m; i++) {
            t = nums[e - i];
            nums[e - i] = nums[s + i];
            nums[s + i] = t;
        }
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length; // 这里要注意，k大于数组大小的时候
        rIndex(nums, 0, nums.length - k - 1);
        rIndex(nums, nums.length - k, nums.length - 1);
        rIndex(nums, 0, nums.length - 1);
    }

    private static void printArray(int[] arr) {
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] arrs = { { 1, 2, 3, 4, 5, 6, 7 }, { -1, -100, 3, 99 }, {-1}, {1, 2, 3} };
        int[] ks = { 3, 2, 2, 4 };
        for (int i = 0; i < ks.length; i++) {
            System.out.println(ks[i]);
            printArray(arrs[i]);
            s.rotate(arrs[i], ks[i]);
            printArray(arrs[i]);
            System.out.println();
        }
    }
}