import java.util.*;

/**
 * 10.02. Group Anagrams LCCI
 * Medium
 * 分组，题目跟排序没啥关系。
 */
public class Solution {

    // 使用字符数量做key，可以只使用存在的<字符+数量>进行拼接，以减少字符串操作
    private String getWordKey(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        StringBuffer k = new StringBuffer();
        for (int i = 0; i < 26; i++) {
            k.append(count[i]);
        }
        return k.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String key = getWordKey(s);
            List<String> t = map.getOrDefault(key, new ArrayList<>());
            t.add(s);
            map.put(key, t);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[][] strings = { { "eat", "tea", "tan", "ate", "nat", "bat" } };
        Solution s = new Solution();
        for (String[] strs : strings) {
            List<List<String>> ans = s.groupAnagrams(strs);
            ans.forEach((a) -> System.out.println(a.toString()));
            System.out.println();
        }
    }
}
