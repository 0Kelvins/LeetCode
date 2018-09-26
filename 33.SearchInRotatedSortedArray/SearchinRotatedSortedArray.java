/**
 * 33. Search in Rotated Sorted Array
 * Medium
 * Runtime complexity:O(log(n))
 * 要求时间复杂度，需要做成二分查找
 * 利用整数除法向下取整，达成循环终止条件
 * 1. 二分法找最小值下标（最大值要向上取整）
 * 2. 取模运算，相对坐标二分查找
*/
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length, l = 0, h = n - 1;
        while (l < h) {
            int m = (l + h) / 2;
            if (nums[m] > nums[h])
                l = m + 1;
            else
                h = m;
        }
        int min = l;
        l = 0; h = n - 1;
        while (l <= h) {
            int m = (l + h) / 2, rel = (m + min) % n;
            if (nums[rel] == target)
                return rel;
            else if (nums[rel] < target)
                l = m + 1;
            else
                h = m - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {4,5,6,7,0,1,2}, b = {0,1,2,4,5,6,7};
        System.out.println(s.search(a, 4));
        System.out.println(s.search(a, 0));
        System.out.println(s.search(a, 3));
        System.out.println(s.search(b, 4));
    }
}