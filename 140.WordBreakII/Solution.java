import java.util.*;
import java.io.*;

/**
 * 140. Word Break II
 * 主要是如何缓存后缀串的对应结果，然后套进前一题方法里就行了，就是要想清楚缓存的数据结构
 */
class Solution {
    private List<String> find(String s, int start, Set<String> dict, Map<Integer, List<String>> map) {
        if (map.containsKey(start))
            return map.get(start);
        List<String> result = new ArrayList<>();
        if (start == s.length())
            result.add("");
        for (int i = start + 1; i <= s.length(); i++) {
            if (dict.contains(s.substring(start, i))) {
                List<String> t = find(s, i, dict, map);
                for (String r : t)
                    result.add(s.substring(start, i) + (i != s.length() ? " " : "") + r);
            }
        }
        map.put(start, result);
        return result;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<String>> map = new HashMap<>();
        Set<String> dict = new HashSet<>(wordDict);
        return find(s, 0, dict, map);
    }

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        File f = new File("input.txt");
        Scanner scan = new Scanner(f);
        while (scan.hasNextLine()) {
            List<String> in = Arrays.asList(scan.nextLine().split(" "));
            String string = in.get(0);
            System.out.println(s.wordBreak(string, in.subList(1, in.size())).toString());
        }
        scan.close();
    }
}