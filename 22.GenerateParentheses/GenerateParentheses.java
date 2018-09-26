import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> r = new ArrayList<String>();
        generate(r, n, 0, 0, "");
        return r;
    }

    public void generate(List<String> result, int n, int l, int r, String s) {
        if (r == n) 
            result.add(s);

        if (l < n) generate(result, n, l+1, r, s+"(");
        if (r < l) generate(result, n, l, r+1, s+")");
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> r = s.generateParenthesis(3);
        for (String str : r) {
            System.out.println(str);
        }
    }
}