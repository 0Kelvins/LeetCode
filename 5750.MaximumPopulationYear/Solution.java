import java.util.*;
/**
 * 5750. Maximum Population Year
 * Easy
 */
public class Solution {
    public int maximumPopulation(int[][] logs) {
        int max = 0, cur = 0, maxYear = 0;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < logs.length; i++) {
            list.add(new int[] {logs[i][0], 1});
            list.add(new int[] {logs[i][1], -1});
        }
        Collections.sort(list, (a,b)->a[0]-b[0]);
        for (int i = 0; i < list.size(); i++) {
            cur += list.get(i)[1];
            // System.out.println(cur +" "+ list.get(i)[0]);
            if (i<list.size()-1 && list.get(i+1)[0] > list.get(i)[0] && cur > max) {
                max = cur;
                maxYear = list.get(i)[0];
            }
        }
        return maxYear;
    }

    public static void main(String[] args) {
        int[][] in = {{2008,2026},{2004,2008},{2034,2035},{1999,2050},{2049,2050},{2011,2035},{1966,2033},{2044,2049}};
        Solution sol = new Solution();
        System.out.println(sol.maximumPopulation(in));
    }
}