import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 229. Majority Element II
 * Meidum
 */
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = nums[0], count1 = 0, candidate2 = nums[0], count2 = 0;
        for (int i : nums) {
            if (i == candidate1) {
                count1++;
                continue;
            }
            if (i == candidate2) {
                count2++;
                continue;
            }
            if (count1 == 0) {
                candidate1 = i;
                count1++;
                continue;
            }
            if (count2 == 0) {
                candidate2 = i;
                count2++;
                continue;
            }
            count1--;
            count2--;
        }

        count1 = count2 = 0;
        for (int i : nums) {
            count1 = i == candidate1 ? count1 + 1 : count1;
            count2 = i == candidate2 ? count2 + 1 : count2;
        }
        List<Integer> ans = new ArrayList<>();
        if (count1 > nums.length / 3) {
            ans.add(candidate1);
        }
        if (candidate2 != candidate1 && count2 > nums.length / 3) {
            ans.add(candidate2);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] nums = { { 3, 2, 3 }, { 1 }, { 1, 2 }, { 2, 1, 1, 3, 1, 4, 5, 6 } };
        Solution s = new Solution();
        for (int i = 0; i < nums.length; i++) {
            System.out.println(s.majorityElement(nums[i]).toString());
        }
    }
}
