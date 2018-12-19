/**
 * 35. Search Insert Position
 * easy
 * 1. sorted array 2. no duplicates
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        int end = nums.length - 1;
        if (nums.length == 0 || target < nums[0])
            return 0;
        if (target > nums[end])
            return end + 1;
        return binarySearch(nums, 0, end, target);
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        int mid = (start + end) / 2;
        if (start > end) 
            return start;
        if (target > nums[mid])
            start = mid + 1;
        else if (target < nums[mid])
            end = mid - 1;
        else
            return mid;
        return binarySearch(nums, start, end, target);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 3, 5, 7};
        System.out.println(s.searchInsert(nums, 5));
        System.out.println(s.searchInsert(nums, 2));
        System.out.println(s.searchInsert(nums, 6));
        System.out.println(s.searchInsert(nums, 7));
        System.out.println(s.searchInsert(nums, 8));
        System.out.println(s.searchInsert(nums, 0));
        int[] nums2 = {1,2,3,4,5,10};
        System.out.println(s.searchInsert(nums2, 2));
    }
}