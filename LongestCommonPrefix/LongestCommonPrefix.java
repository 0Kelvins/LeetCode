/**
 * 14. Longest Common Prefix
 * easy or hard?
 * 逐个逐字匹配出最长前缀（easy）
 * 二分查找优化匹配效率（medium+）
 * Trie（Prefix Tree）树检索（hard）
*/
class Solution {
    // 逐个匹配
    public String longestCommonPrefix0(String[] strs) {
        if (strs.length < 1) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int m = prefix.length(), n = strs[i].length(), j = 0;
            while (j < m && j < n) {
                if (prefix.charAt(j) == strs[i].charAt(j))
                    j++;
                else
                    break;
            }
            prefix = prefix.substring(0, j);
        }
        return prefix;
    }

    // 二分查找
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle))
                low = middle + 1;
            else
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }
    
    private boolean isCommonPrefix(String[] strs, int len){
        String p = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(p))
                return false;
        return true;
    }

    public static void main(String[] args) {
        String[][] test = {{"flower","flow","flight"},
                           {"dog","racecar","car"},
                           {"aa", "", "a"},
                           {""},
                           {"", "b"},
                           {"aaa", "aaaaa"}};
        Solution s = new Solution();
        for (String[] strs : test) {
            System.out.println(s.longestCommonPrefix(strs));
        }
    }
}