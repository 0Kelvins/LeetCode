import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 455. Assign Cookies
 * easy
 * 排序后贪心，只排一个可能另一个花费时间很长
*/
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int max = 0;
        Arrays.sort(s);
        Arrays.sort(g);
        for (int i = 0; i < s.length && max < g.length; i++) {
            if (g[max] <= s[i]) max++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] g = {{1, 2, 3}, {1, 2}};
        int[][] s = {{1, 1}, {1, 2, 3}};
        Solution solution = new Solution();
        System.out.println(solution.findContentChildren(g[0], s[0]));
        System.out.println(solution.findContentChildren(g[1], s[1]));
    }
}