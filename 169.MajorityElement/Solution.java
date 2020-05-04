import java.util.*;

/**
 * 169. Majority Element
 * 哈希表很简单O(n)，排序取中间位也比较简单但O(nlogn)，投票法利用数学方法更快O(n)O(1)
 */
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i))
                map.put(i, map.get(i) + 1);
            else
                map.put(i, 1);
        }
        int m = 0, t = 0;
        for (Map.Entry<Integer, Integer> i : map.entrySet()) {
            if (i.getValue() > t) {
                t = i.getValue();
                m = i.getKey();
            }
        }
        return m;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] in = { { 3, 2, 3 }, { 2, 2, 1, 1, 1, 2, 2 }, { 1, 2, 3, 4, 5, 5, 5, 5, 5 } };
        for (int[] nums : in) {
            System.out.println(s.majorityElement(nums));
        }
    }
}