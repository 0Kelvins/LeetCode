import java.util.*;

/**
 * 205. Isomorphic Strings
 * Easy
 * 要双向映射
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> smap = new HashMap<>();
        Map<Character, Character> tmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i), b = t.charAt(i);
            if (smap.containsKey(a) && smap.get(a) != b || tmap.containsKey(b) && tmap.get(b) != a) {
                return false;
            } else {
                smap.put(a, b);
                tmap.put(b, a);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] strs = { { "egg", "add" }, { "foo", "bar" }, { "paper", "title" }, { "badc", "baba"} };
        Solution s = new Solution();
        for (String[] str : strs) {
            System.out.println(str[0] + " " + str[1] + " " + s.isIsomorphic(str[0], str[1]));
        }
    }
}
