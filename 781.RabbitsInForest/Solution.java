import java.util.*;

/**
 * 781. Rabbits in Forest
 * Medium
 * 写法可以再优化一下
 */
public class Solution {

    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int min = 0;
        for (int a : answers) {
            if (!map.containsKey(a) || map.get(a) == 0) {
                map.put(a, a);
            } else {
                map.put(a, map.get(a) - 1);
            }
            min++;
        }
        for (int k : map.keySet()) {
            min += map.get(k);
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] answers = { { 1, 1, 2 }, { 10, 10, 10 }, {}, { 1, 1, 1 } };
        Solution s = new Solution();
        for (int[] ans : answers) {
            System.out.println(s.numRabbits(ans));
        }
    }
}