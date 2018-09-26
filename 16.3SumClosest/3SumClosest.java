/**
 * 16. 3Sum Closest
 * medium
 */
import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closest = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length-2; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                int l = i+1, h = nums.length-1;
                while (l < h) {
                    int sum = nums[i] + nums[l] + nums[h];
                    closest = Math.abs(sum - target) > Math.abs(closest - target) ? closest : sum;
                    if (sum < target) l++;
                    else if (sum > target) h--;
                    else break;
                }
                if (closest == target) break;
            }
        }

        return closest;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};

        Solution solution = new Solution();
        int closest = solution.threeSumClosest(nums, 0);

        System.out.println(closest);
    }
}