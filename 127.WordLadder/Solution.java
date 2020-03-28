import java.io.*;
import java.util.*;

/**
 * 127. Word Ladder
 * 有点难，就没想到逐个字符进行BFS
 */
class Solution {
    // BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int len = 1;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                StringBuilder cur = new StringBuilder(queue.poll());
                for (int j = 0; j < cur.length(); j++) {
                    char old = cur.charAt(j);
                    for (char k = 'a'; k <= 'z'; k++) { // 检查当前词的当前字符修改为任意字符在wordList中是否存在
                        cur.setCharAt(j, k);
                        if (words.contains(cur.toString())) {
                            String t = cur.toString();
                            if (t.equals(endWord))
                                return len + 1;
                            words.remove(t);
                            queue.offer(t);
                        }
                    }
                    cur.setCharAt(j, old);
                }
            }
            len++;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        File f = new File("input.txt");
        Scanner scan = new Scanner(f);
        while (scan.hasNext()) {
            String beginWord = scan.next();
            String endWord = scan.next();
            String[] words = scan.next().split(",");
            System.out.println(s.ladderLength(beginWord, endWord, Arrays.asList(words)));
        }
        scan.close();
    }
}