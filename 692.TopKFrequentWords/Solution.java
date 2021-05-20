import java.util.*;

/**
 * 692. Top K Frequent Words
 * Meidum
 */
public class Solution {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (a, b) -> (a.getValue() == b.getValue())
                ? (a.getKey().compareTo(b.getKey()))
                : (b.getValue() - a.getValue()));
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(list.get(i).getKey());
        }
        return ans;
    }
    
    public static void main(String[] args) {
        String[][] words = { { "i", "love", "leetcode", "i", "love", "coding" },
                { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" } };
        int[] k = { 2, 4 };
        Solution s = new Solution();
        for (int i = 0; i < k.length; i++) {
            System.out.println(s.topKFrequent(words[i], k[i]).toString());
        }
    }
}