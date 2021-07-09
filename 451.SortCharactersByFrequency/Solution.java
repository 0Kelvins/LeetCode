import java.util.*;

/**
 * 451. Sort Characters By Frequency
 * Medium---
 * 这题蛮有用的，解决了我Map如何按Value优雅排序的问题
 */
public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Character> list = new ArrayList<>(map.keySet());      // key列表
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a)); // 取map的value排序
        StringBuilder builder = new StringBuilder();
        for (Character character : list) {
            int count = map.get(character);
            for (int i = 0; i < count; i++) {
                builder.append(character);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String[] strs = { "tree", "cccaaa", "Aabb", "eeeerraaad" };
        Solution sol = new Solution();
        for (String s : strs) {
            System.out.println(sol.frequencySort(s));
        }
    }
}
