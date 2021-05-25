import java.util.*;

/**
 * 241. Different Ways to Add Parentheses
 * Meidum+
 * 这题有一点麻烦的
 */
public class Solution {

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    private List<Integer> diffWays(char[] exp, int start, int end, Map<Integer, List<Integer>> cache) {
        List<Integer> ans = new ArrayList<>();
        int t = 0;
        boolean expIsNumber = true;
        for (int i = start; i <= end; i++) {
            if (isNumber(exp[i])) {
                t = t * 10 + exp[i] - '0';
            } else {
                expIsNumber = false;
                List<Integer> prefix;
                int key = start * 100 + i - 1;
                if (cache.containsKey(key)) {
                    prefix = cache.get(key);
                } else {
                    prefix = diffWays(exp, start, i - 1, cache);
                    cache.put(key, prefix);
                }
                List<Integer> suffix;
                key = (i + 1) * 100 + end;
                if (cache.containsKey(key)) {
                    suffix = cache.get(key);
                } else {
                    suffix = diffWays(exp, i + 1, end, cache);
                    cache.put(key, suffix);
                }
                for (int j = 0; j < prefix.size(); j++) {
                    for (int k = 0; k < suffix.size(); k++) {
                        switch (exp[i]) {
                            case '+':
                                ans.add(prefix.get(j) + suffix.get(k));
                                break;
                            case '-':
                                ans.add(prefix.get(j) - suffix.get(k));
                                break;
                            case '*':
                                ans.add(prefix.get(j) * suffix.get(k));
                                break;
                        }
                    }
                }
            }
        }
        if (expIsNumber) {
            ans.add(t);
        }
        return ans;
    }

    public List<Integer> diffWaysToCompute(String expression) {
        if (expression.charAt(0) == '-' || expression.charAt(0) == '+') {
            expression = "0" + expression;
        }
        char[] exp = expression.toCharArray();
        return diffWays(exp, 0, exp.length-1, new HashMap<>());
    }

    public static void main(String[] args) {
        String[] expression = { "2-1-1", "2*3-4*5", "-2-1", "11-200-11" };
        Solution s = new Solution();
        for (String exp : expression) {
            System.out.println(s.diffWaysToCompute(exp).toString());
        }
    }
}
