import java.io.*;
import java.util.*;

/**
 * 139. Word Break
 * emmm，还是欠火候啊，暴力查找和BFS时后缀串在查找的时候会被反复查找，需要对后缀串的查找结果进行缓存。dp依然是思路似曾相识，就是想不起来
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        File f = new File("input.txt");
        Scanner scan = new Scanner(f);
        while (scan.hasNextLine()) {
            List<String> in = Arrays.asList(scan.nextLine().split(" "));
            String string = in.get(0);
            System.out.println(s.wordBreak(string, in.subList(1, in.size())));
        }
        scan.close();
    }
}