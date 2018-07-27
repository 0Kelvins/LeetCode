/**
 * 15. 3Sum
 * medium
 * 转化为 TwoSum 问题 (Arrays Java8)
 */
import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> zeros = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length-2; i++) {
            if (nums[i] <= 0 && (i == 0 || nums[i] != nums[i-1])) {
                int target = -nums[i], l = i+1, h = nums.length-1;
                while (l < h) {
                    int t = nums[l] + nums[h];
                    if (t < target) l++;
                    else if (t > target) h--;
                    else {
                        zeros.add(Arrays.asList(nums[i], nums[l], nums[h]));
                        while (l < h && nums[l] == nums[l+1]) l++;
                        while (l < h && nums[h] == nums[h-1]) h--;
                        l++; h--;
                    }
                }
            }
        }

        return zeros;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        Solution solution = new Solution();
        List<List<Integer>> zeros = solution.threeSum(nums);

        for (List<Integer> l : zeros) {
            System.out.println(Arrays.toString(l.toArray()));
        }
    }
}