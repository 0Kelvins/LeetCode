import java.util.*;

/**
 * 1239. Maximum Length of a Concatenated String with Unique Characters
 * Meidum
 */
public class Solution {
    public int maxLength(List<String> arr) {
        int n = arr.size();
        int[] bitmap = new int[n];
        for (int i = 0; i < n; i++) {
            String s = arr.get(i);
            for (int j = 0; j < s.length(); j++) {
                int cnum = s.charAt(j) - 'a';
                int bit = 1 << cnum;
                if ((bitmap[i] & bit) > 0) {
                    bitmap[i] = -1;
                } else {
                    bitmap[i] |= bit;
                }
            }
        }
        List<List<Integer>> dp = new ArrayList<>(); // 01背包
        for (int i = 0; i <= 26; i++) { // 不同字符数下对应字符串数组
            dp.add(new ArrayList<>());
        }
        dp.get(0).add(0);
        for (int i = 0; i < n; i++) {
            if (bitmap[i] < 0) {
                continue;
            }
            int l = arr.get(i).length();
            for (int j = 26; j >= l; j--) {
                int tn = dp.get(j - l).size();
                if (tn > 0) {
                    for (int k = 0; k < tn; k++) {
                        int ts = dp.get(j - l).get(k);
                        if ((ts & bitmap[i]) == 0) {
                            dp.get(j).add(ts | bitmap[i]);
                        }
                    }
                }
            }
        }
        for (int i = 26; i >= 0; i--) {
            if (dp.get(i).size() > 0) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String[][] arrs = { { "un", "iq", "ue" }, { "cha", "r", "act", "ers" }, { "abcdefghijklmnopqrstuvwxyz" } };
        Solution s = new Solution();
        for (String[] arr : arrs) {
            System.out.println(s.maxLength(Arrays.asList(arr)));
        }
    }
}
