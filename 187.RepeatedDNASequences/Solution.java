import java.util.*;

/**
 * 187. Repeated DNA Sequences
 * Medium
 * Rabin-Karp：可以将核酸缩写映射到数字，然后视为基数位4的10位数字，这样移位时运算可以只考虑前导位和末尾位数字进行快速计算
 * 掩码：将字母映射到比特位，思路与上类似
 */
public class Solution {

    // 用HashSet更简洁。
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> r = new ArrayList<>();
        if (s.length() < 10)
            return r;
        
        Map<String, Integer> map = new HashMap<>();
        String t;

        for (int i = 0; i <= s.length() - 10; i++) {
            t = s.substring(i, i + 10);
            if (map.containsKey(t)) {
                int n = map.get(t) + 1;
                map.put(t, n);
                if (n == 2)
                    r.add(t);
            } else {
                map.put(t, 1);
            }
        }

        return r;
    }

    public static void main(String[] args) {
        String[] ss = { "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT", "AAAAACCCCCAAAAACCCCCAAAAAGGGTTTAAAAAGGGTTT", "AAAAAAAAAAAAA", "AAAAAAAAAAATA", "AAAAAAAAAA" };
        Solution solution = new Solution();
        for (String s : ss) {
            System.out.println(s);
            List<String> r = solution.findRepeatedDnaSequences(s);
            r.forEach((i) -> System.out.print(i + " "));
            System.out.println();
            System.out.println();
        }
    }
}
