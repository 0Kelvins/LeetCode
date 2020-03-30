import java.util.*;

/**
 * 128. Longest Consecutive Sequence
 * foreach效率比fori要低
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int t : nums)
            set.add(t);
        int longest = 0;
        for (int t : nums) {
            if (!set.contains(t - 1)) {
                int l = t + 1;
                while (set.contains(l))
                    l++;
                longest = Math.max(l - t, longest);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        System.out.println(s.longestConsecutive(nums));
    }
}