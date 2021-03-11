import java.util.*;

/**
 * 50. 第一个只出现一次的字符
 * Easy
 * 这题我虽然做出来了，但是一开始想用HashMap做没想清楚，还是需要多用用Map
 */
public class Solution {

    public char firstUniqChar0(String s) {
        int[][] dict = new int[26][2];  // 26个字母对应首次出现位置（大于0）及次数
        for (int i = 0; i < s.length(); i++) {
            int j = s.charAt(i) - 'a';
            if (dict[j][0] == 0)
                dict[j][0] = i + 1;
            dict[j][1]++;
        }
        int i = 50002;
        char r = ' ';
        for (int j = 0; j < 26; j++) {
            if (dict[j][1] == 1 && dict[j][0] > 0 && dict[j][0] < i) {
                r = (char) ('a' + j);
                i = dict[j][0];
            }
        }
        return r;
    }

    // 有序HashMap，就是反而更慢了
    public char firstUniqChar(String s) {
        LinkedHashMap<Character, Boolean> map = new LinkedHashMap<>();
        for (Character c : s.toCharArray())
            map.put(c, !map.containsKey(c));
        
        for (Character c : map.keySet()) {
            if (map.get(c))
                return c;
        }
        return ' ';
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] strs = { "abaccdeff", "" };
        for (String s : strs) {
            System.out.println(sol.firstUniqChar(s));
        }
    }
}