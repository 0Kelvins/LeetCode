import java.util.*;

/**
 * 45. 把数组排成最小的数
 * Medium
 * 练练快排
 */
public class Solution {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder builder = new StringBuilder();
        for (String i : strs) {
            builder.append(i);
        }
        return builder.toString();
    }

    private void quickSort(String[] strs, int start, int end) {
        if(start >= end)
            return;
        int i = start, j = end;
        String p = strs[i];
        while (i < j) {
            while ((strs[j] + p).compareTo(p + strs[j]) >= 0 && i < j)
                j--;
            strs[i] = strs[j];
            while ((strs[i] + p).compareTo(p + strs[i]) <= 0 && i < j)
                i++;
            strs[j] = strs[i];
        }
        strs[i] = p;
        quickSort(strs, start, i - 1);
        quickSort(strs, i + 1, end);
    }

    public String minNumber2(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        
        quickSort(strs, 0, nums.length - 1);

        StringBuilder builder = new StringBuilder();
        for (String i : strs)
            builder.append(i);
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] inputs = { { 10, 2 }, { 3, 30, 34, 5, 9 }, {1, 0}, {12, 121} };
        for (int[] nums : inputs) {
            System.out.println(sol.minNumber2(nums));
        }
    }
}