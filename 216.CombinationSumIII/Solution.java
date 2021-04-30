import java.util.*;

/**
 * 216. Combination Sum III
 * Medium
 * 回溯
 */
public class Solution {

    private void dfs(List<List<Integer>> ans, List<Integer> t, int k, int n) {
        if (n == 0 && k == 0) {
            ans.add(new ArrayList<>(t));
            return;
        }
        int start = t.size() > 0 ? t.get(t.size()-1) + 1 : 1; // 直接从后面继续查找避免重复
        for (int i = start; i < 10; i++) {
            if (i > n || k == 0) {
                break;
            }
            t.add(i);
            dfs(ans, t, k - 1, n - i);
            t.remove(t.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        if (n > 45 || k > n) {
            return ans;
        }
        List<Integer> t = new ArrayList<>();
        dfs(ans, t, k, n);
        return ans;
    }

    public static void main(String[] args) {
        int[][] in = { { 3, 7 }, { 3, 9 }, { 4, 1 }, { 2, 2 }, { 9, 45 } };
        Solution s = new Solution();
        for (int[] kn : in) {
            System.out.println(s.combinationSum3(kn[0], kn[1]).toString());
        }
    }
}