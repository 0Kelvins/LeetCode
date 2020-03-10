import java.util.*;
import java.io.*;

/**
 * 87. Scramble String
 * 这题题目有点迷惑。扰乱节点是一定扰乱该节点以下所有节点，还是可以扰乱任意单个节点，很容易没搞清楚
 * 不愧是👎比较多的Hard题。👍
 */
class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        int len = s1.length();
        if (s2.length() != len)
            return false;
        int[] count = new int[256];
        for (int i = 0; i < len; i++) { // 可以扰乱任意单个节点，所以只要统计子串字符数量一致即可
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }
        for (int i = 0; i < len; i++) {
            if (count[s1.charAt(i)] != 0)
                return false;
        }
        for (int i = 1; i < len; i++) {
            // abcde bacde
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
                return true;
            // abcde cdeba
            if (isScramble(s1.substring(0, i), s2.substring(len - i))
                    && isScramble(s1.substring(i), s2.substring(0, len - i)))
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        File f = new File("input.txt");
        Scanner scan = new Scanner(f);
        while (scan.hasNext()) {
            String a = scan.next();
            String b = scan.next();
            System.out.println(s.isScramble(a, b));
        }
        scan.close();
    }
}