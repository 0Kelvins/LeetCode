import java.util.*;

/**
 * 242. Valid Anagram
 * Easy
 * javac -encoding utf-8
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            if (counter.getOrDefault(c, 0) == 0) {
                return false;
            } else {
                counter.put(c, counter.get(c) - 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] strs = { { "测试", "试测" }, { "测试", "参数测试" } };
        Solution sol = new Solution();
        for (String[] st : strs) {
            System.out.println(sol.isAnagram(st[0], st[1]));
        }
    }
}
