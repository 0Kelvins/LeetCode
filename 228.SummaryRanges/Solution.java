import java.util.ArrayList;
import java.util.List;

/**
 * 228. Summary Ranges
 * Easy
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<String>();
        if (nums.length == 0) {
            return ans;
        }
        int i = 0, start = 0;
        while (i < nums.length) {
            start = i;
            while ((i + 1 < nums.length) && (nums[i + 1] == nums[i] + 1)) {
                i++;
            }
            StringBuilder builder = new StringBuilder(Integer.toString(nums[start]));
            if (start < i) {
                builder.append("->");
                builder.append(Integer.toString(nums[i]));
            }
            ans.add(builder.toString());
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] nums = { {}, { 0, 1, 2, 4, 5, 7 }, { 0, 2, 3, 4, 6, 8, 9 }, { -1 }, { 0 },
                { -2147483648, -2147483647, 2147483647 } };
        Solution s = new Solution();
        for (int[] ns : nums) {
            System.out.println(s.summaryRanges(ns).toString());
        }
    }
}
