import java.util.*;

/**
 * 1711. Count Good Meals
 * Medium
 * 可以先查到maxDeliciousness，优化pow数组大小
 */
public class Solution {
    private List<Integer> twoPow;
    private static int mod = (int) 1e9 + 7;

    public Solution() {
        twoPow = new ArrayList<>();
        for (int i = 21; i >= 0; i--) {
            twoPow.add(1 << i);
        }
    }

    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> count = new HashMap<>();
        int total = 0;
        for (int d : deliciousness) {
            for (int p : twoPow) {
                if (p < d) {
                    break;
                }
                total = (total + count.getOrDefault(p - d, 0)) % mod;
            }
            count.put(d, count.getOrDefault(d, 0) + 1);
        }
        return total;
    }

    public static void main(String[] args) {
        int[][] deliciousness = { { 1, 3, 5, 7, 9 }, { 1, 1, 1, 3, 3, 3, 7 },
                { 149, 107, 1, 63, 0, 1, 6867, 1325, 5611, 2581, 39, 89, 46, 18, 12, 20, 22, 234 } };
        Solution s = new Solution();
        for (int[] d : deliciousness) {
            System.out.println(s.countPairs(d));
        }
    }
}