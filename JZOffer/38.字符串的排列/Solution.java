import java.util.*;

/**
 * 剑指 Offer 38. 字符串的排列
 * Medium
 * 应该做过类似的排列题，时间太久了就还是要重新想
 */
public class Solution {

    private void recur(List<String> res, String str, List<String> chars) {
        if (chars.size() == 0) {
            res.add(str);
            return;
        }
        Set<String> set = new HashSet<>();  // 当前层集合
        for (int i = 0; i < chars.size(); i++) {
            if(set.contains(chars.get(i)))  // 剪枝
                continue;
            String t = chars.remove(i);
            set.add(t);
            recur(res, str + t, chars);
            chars.add(i, t);
        }
    }

    public String[] permutation(String s) {
        List<String> res = new ArrayList<>();
        List<String> charList = new LinkedList<>();
        for (char c : s.toCharArray()) {
            charList.add(String.valueOf(c));
        }
        recur(res, "", charList);
        return res.toArray(new String[res.size()]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] strings = { "abc", "abcd", "a", "aab" };
        for (String str : strings) {
            String[] res = s.permutation(str);
            System.out.println(String.join(",", res));
        }
    }
}