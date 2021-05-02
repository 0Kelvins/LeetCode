import java.util.*;
import java.util.stream.Collectors;

/**
 * 554. Brick Wall
 * Medium
 * 找到规律就很好解了。。用map存下每行逐个累加相同值的个数，然后遍历map用高度减去对应值即是那条缝对应的结果。
 * 但是没想起来
 */
public class Solution {
    
    public int leastBricks(List<List<Integer>> wall) {
        int n = wall.size();
        int[][] record = new int[n][2]; // 0: index, 1: sum
        boolean isEnd = false;
        int line = 1, min = n, flag, rowSum = Integer.MAX_VALUE, count = n, minSum;
        while (!isEnd) {
            flag = 0;
            minSum = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                // System.out.println(record[i][0] + " " + record[i][1]);
                if (record[i][1] <= line) {
                    if (record[i][1] == line) {
                        count--;
                    }
                    List<Integer> row = wall.get(i);
                    if (record[i][0] < row.size()) {
                        record[i][1] += row.get(record[i][0]);
                        record[i][0]++;
                    }
                    if (record[i][0] == row.size()) {
                        rowSum = record[i][1];
                    }
                    flag = 1;
                }
                minSum = Math.min(minSum, record[i][1]);
            }
            // System.out.println("l:" + line);
            // System.out.println();
            if (flag == 0) {
                min = Math.min(min, count);
                count = n;
                line = minSum;
            }
            if (line == rowSum) {
                isEnd = true;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int[][][] walls = { { { 1, 2, 2, 1 }, { 3, 1, 2 }, { 1, 3, 2 }, { 2, 4 }, { 3, 1, 2 }, { 1, 3, 1, 1 } },
                { { 1 }, { 1 }, { 1 } }, { { 7, 1, 2 }, { 3, 5, 1, 1 }, { 10 } } };
        Solution s = new Solution();
        for (int[][] wall : walls) {
            List<List<Integer>> list = new ArrayList<>();
            for (int[] w : wall) {
                list.add(Arrays.stream(w).boxed().collect(Collectors.toList()));
            }
            System.out.println(s.leastBricks(list));
        }
    }
}
