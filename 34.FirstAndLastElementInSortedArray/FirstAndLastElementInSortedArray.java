/**
 * 34. Find First and Last Position of Element in Sorted Array
 * Medium
 * Binary Search
 * 解决思路很简单，实现时注意边界就可以了
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] range = { -1, -1 };

        if (nums.length == 1) {
            if (nums[0] == target) {
                range[0] = 0; range[1] = 0;
                return range;
            }
        }
        else if (nums.length > 1) { // 三部分二分查找
            int i = 0, j = nums.length - 1, m = j / 2, s = i, e = j;
            while (i <= j) {    // 查找等于target的一个值下标
                if (nums[m] > target) j = m - 1;
                else if (nums[m] < target) i = m + 1;
                else break;
                m = (i + j) / 2;
            }
            if (nums[m] == target) {
                i = 0; j = m;
                while (i <= j) {    // 查找起点下标
                    s = (i + j) / 2;
                    if (s > 0 && nums[s-1] == target) j = s - 1;
                    else if ((s == 0 || nums[s-1] < target) && nums[s] == target) break;
                    else i = s + 1;
                }
                range[0] = s;
    
                i = m; j = nums.length - 1;
                while (i <= j) {    // 查找终点下标
                    e = (i + j) / 2;
                    if (e < nums.length - 1 && nums[e+1] == target) i = e + 1;
                    else if ((e == nums.length - 1 || nums[e+1] > target) && nums[e] == target) break;
                    else j = e - 1;
                }
                range[1] = e;    
            }
        }
        
        return range;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = { 5,7,7,8,8,10 };
        int[] range = s.searchRange(nums, 8);
        System.out.println(range[0] + ", " + range[1]);
        range = s.searchRange(nums, 5);
        System.out.println(range[0] + ", " + range[1]);
        range = s.searchRange(nums, 6);
        System.out.println(range[0] + ", " + range[1]);
    }
}