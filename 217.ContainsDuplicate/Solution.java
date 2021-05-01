import java.util.HashSet;
import java.util.Set;

/**
 * 217. Contains Duplicate
 * Easy
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.add(i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = { { 1, 2, 3, 1 }, { 1, 2, 3, 4 }, { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 } };
        Solution s = new Solution();
        for (int[] ns : nums) {
            System.out.println(s.containsDuplicate(ns));
        }
    }
}
