/**
 * 137. Single Number II
 * Single Number这两题是考位运算的。但是不熟悉的话是真想不起来，且3个或以上重复的实现也是不容易的
 */
class Solution {
    public int singleNumber(int[] nums) {
        int once = 0, twice = 0; // 扩展位
        for (int i : nums) {
            once = (i ^ once) & ~twice; // 当once=twice=0，i=1时，这个i出现1次，当i=0时，once不变
            twice = (i ^ twice) & ~once; // 当once=twice=0（前句刚计算的once），i=1时，i出现2次，当i=0时，twice不变
        }
        return once;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] nums = { { 2, 2, 3, 2 }, { 0, 1, 0, 1, 0, 1, 99 } };
        for (int[] num : nums)
            System.out.println(s.singleNumber(num));
    }
}