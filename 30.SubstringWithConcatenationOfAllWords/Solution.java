import java.util.*;

/**
 * 30. Substring with Concatenation of All Words
 * Hard
 * 使用了字典树，好像有点大才小用了
 */
public class Solution {

    // 构建字典树
    private TreeNode createDictTree(String[] words) {
        TreeNode root = new TreeNode(' ');
        TreeNode p;
        for (String w : words) {
            p = root;
            for (char c : w.toCharArray()) {
                if (!p.getChild().containsKey(c)) {
                    p.setChild(c);
                }
                p = p.getChild().get(c);
            }
            p.setWord(w);
            p.setCount(p.getCount() + 1);
        }
        return root;
    }

    // 搜索字典树匹配单个单词
    private boolean search(TreeNode node, String s, int i, Map<String, Integer> map) {
        if (node.getChild().size() == 0) { // 搜索到一个单词
            int wn = map.getOrDefault(node.getWord(), 0);
            if (wn == node.getCount()) {    // 该单词数量超过给出单词数量
                return false;
            }
            map.put(node.getWord(), wn + 1);
            return true;
        } else if (i == s.length() || !node.getChild().containsKey(s.charAt(i))) {
            // s遍历结束，或搜索失配
            return false;
        }
        return search(node.getChild().get(s.charAt(i)), s, i + 1, map);
    }

    // 搜索连续匹配
    private boolean match(TreeNode node, String s, int i, int n, int l) {
        Map<String, Integer> map = new HashMap<>();
        for (int j = 0; j < n; j++) {
            if (!search(node, s, i + j * l, map)) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        TreeNode dict = createDictTree(words);
        List<Integer> res = new ArrayList<>();
        int n = words.length, l = words[0].length();
        for (int i = 0; i <= s.length() - n * l; i++) {
            if (match(dict, s, i, n, l)) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] ss = { "barfoothefoobarman", "wordgoodgoodgoodbestword", "barfoofoobarthefoobarman", "wordgoodgoodgoodbestword" };
        String[][] words = { { "foo", "bar" }, { "word", "good", "best", "word" }, { "bar", "foo", "the" }, {"word","good","best","good"} };
        for (int i = 0; i < ss.length; i++) {
            List<Integer> res = sol.findSubstring(ss[i], words[i]);
            System.out.println(res.toString());
        }
    }
}

class TreeNode {
    private Character c;
    private String word;
    private int count;
    private Map<Character, TreeNode> child;

    TreeNode(char c) {
        this.c = c;
        this.child = new HashMap<>();
    }

    public char getC() {
        return c;
    }
    
    public void setC(char c) {
        this.c = c;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Map<Character, TreeNode> getChild() {
        return child;
    }

    public void setChild(char c) {
        this.child.put(c, new TreeNode(c));
    }

    public void setChild(Map<Character, TreeNode> child) {
        this.child = child;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TreeNode) {
            TreeNode t = (TreeNode) obj;
            return this.getC() == t.getC();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return c.hashCode() + count * 100;
    }
}