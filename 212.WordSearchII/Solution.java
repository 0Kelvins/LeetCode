import java.util.*;

/**
 * 212. Word Search II
 * Hard
 * 字典树，注意的是结尾标记的位置
 */
public class Solution {

    private void find(Set<String> res, char[][] board, Trie p, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length)
            return;
        Character t = board[i][j];
        if (p.child.containsKey(t)) {
            Trie next = p.child.get(t);
            if (next.isEnd) {
                res.add(next.word);
            }
            board[i][j] = ' ';
            find(res, board, next, i + 1, j);
            find(res, board, next, i, j + 1);
            find(res, board, next, i - 1, j);
            find(res, board, next, i, j - 1);
            board[i][j] = t;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<>();
        Trie trie = createTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                find(res, board, trie, i, j);
            }
        }
        return new ArrayList<>(res);
    }
    
    private Trie createTrie(String[] words) {
        Trie root = new Trie(), p = root;

        for (String w : words) {
            p = root;
            for (int i = 0; i < w.length(); i++) {
                Character c = w.charAt(i);
                if (!p.child.containsKey(c)) {
                    p.child.put(c, new Trie());
                }
                p = p.child.get(c);
                if (i == w.length() - 1) {
                    p.isEnd = true;
                    p.word = w;
                }
            }
        }

        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] board1 = {
                { 'o', 'a', 'a', 'n' }, 
                { 'e', 't', 'a', 'e' }, 
                { 'i', 'h', 'k', 'r' },
                { 'i', 'f', 'l', 'v' } };
        String[] words1 = { "oath", "pea", "eat", "rain" };
        String[] words3 = { "oa", "oaa" };
        List<String> res1 = s.findWords(board1, words1);
        System.out.println(res1.toString());
        List<String> res3 = s.findWords(board1, words3);
        System.out.println(res3.toString());

        char[][] board2 = { { 'a', 'b' }, { 'c', 'd' } };
        String[] words2 = { "abcb" };
        List<String> res2 = s.findWords(board2, words2);
        System.out.println(res2.toString());

        char[][] board4 = { { 'a', 'b' }, { 'a', 'a' } };
        String[] words4 = { "aba", "baa", "bab", "aaab", "aaa", "aaaa", "aaba" };
        List<String> res4 = s.findWords(board4, words4);
        System.out.println(res4.toString());
    }
}

/**
 * Trie
 */
class Trie {
    public boolean isEnd;
    public String word;
    public Map<Character, Trie> child;

    public Trie() {
        this.isEnd = false;
        this.word = null;
        this.child = new HashMap<>();
    }
} 