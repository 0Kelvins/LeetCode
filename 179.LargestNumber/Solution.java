import java.util.*;

/**
 * 179. Largest Number
 * 这个自定义排序写的有点少，正好记一记
 */
class Solution {
    private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String m = a + b, n = b + a;
            return n.compareTo(m);
        }
    }

    public String largestNumber(int[] nums) {
        if (nums.length == 0)
            return "0";
        String[] num = new String[nums.length];
        for (int i = 0; i < num.length; i++)
            num[i] = String.valueOf(nums[i]);
        Arrays.sort(num, new LargerNumberComparator());
        if ("0".equals(num[0]))
            return "0";
        StringBuilder s = new StringBuilder();
        for (String i : num)
            s.append(i);
        return s.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] in = { { 10, 2 }, { 3, 30, 34, 5, 9 }, { 0, 0 }, { 0, 1, 0 }, { 11, 2, 12 } };
        for (int[] nums : in) {
            System.out.println(s.largestNumber(nums));
        }
    }
}