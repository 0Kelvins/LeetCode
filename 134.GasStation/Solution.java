import java.io.*;
import java.util.*;

/**
 * 134. Gas Station
 * 找规律题。起点必然在气不够的站后面
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, sum = 0, total = 0;
        for (int i = 0; i < gas.length; i++) {
            int t = gas[i] - cost[i];
            total += t;
            sum += t;
            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }
        return total >= 0 ? start : -1;
    }

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        File f = new File("input.txt");
        Scanner scan = new Scanner(f);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            int[] gas = new int[n];
            int[] cost = new int[n];
            for (int i = 0; i < n; i++)
                gas[i] = scan.nextInt();
            for (int i = 0; i < n; i++)
                cost[i] = scan.nextInt();
            System.out.println(s.canCompleteCircuit(gas, cost));
        }
        scan.close();
    }
}