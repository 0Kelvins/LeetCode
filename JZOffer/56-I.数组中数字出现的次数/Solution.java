/**
 * 56 - I. 数组中数字出现的次数
 * Medium
 * 全部数异或得到两个单数的异或，因为两个数不同，所以肯定有一位不同，利用这一位再来遍历数组求得两个数
 * 时间复杂度O(2n)
 */
public class Solution {
    public int[] singleNumbers(int[] nums) {
        int t = 0;
        for (int i : nums)
            t ^= i;
        int m = t & (-t);   // 最小为1的位
        int a = 0, b = 0;
        for (int i : nums) {
            if ((m & i) == 0)
                a ^= i;
            else
                b ^= i;
        }
        return new int[] { a, b };
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] numbers = { { 4, 1, 4, 6 }, { 1, 2, 10, 4, 1, 4, 3, 3 } };
        for (int[] nums : numbers) {
            int[] res = sol.singleNumbers(nums);
            for (int r : res) {
                System.out.println(r);
            }
        }
    }
}
