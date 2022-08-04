/**
 * 330. Patching Array
 * Hard
 */
public class Solution {

    public int minPatches(int[] nums, int n) {
        long total = 1; // 覆盖范围
        int patch = 0; // 增加数数量
        int index = 0; // 用到的最大数下标
        while (total <= n) {
            if (index < nums.length && total >= nums[index]) {
                total += nums[index];
                index++;
            } else {
                total *= 2; // 加一个现在刚好覆盖不到的重量的砝码，覆盖范围翻倍
                patch++;
            }
        }
        return patch;
    }

    public static void main(String[] args) {
        int[][] nums = { { 1, 3 }, { 1, 5, 10 }, { 1, 2, 2 } };
        int[] n = { 6, 20, 5 };
        Solution sol = new Solution();
        for (int i = 0; i < n.length; i++) {
            System.out.println(sol.minPatches(nums[i], n[i]));
        }
    }
}
