/**
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * Medium
 * 这两题好像有做过类似的印象，就是想不起来了╮(╯▽╰)╭
 * 状态转移还是要拿纸好好画画。
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int bit_1 = 0, bit_2 = 0;
        for (int i : nums) {
            bit_1 = bit_1 ^ i & ~bit_2;
            bit_2 = bit_2 ^ i & ~bit_1;
        }
        return bit_1;
    }

    public static void main(String[] args) {
        int[][] numbers = { { 3, 4, 3, 3 }, { 9, 1, 7, 9, 7, 9, 7 } };
        Solution sol = new Solution();
        for (int[] nums : numbers) {
            System.out.println(sol.singleNumber(nums));
        }
    }
}
