/**
 * 208. Implement Trie (Prefix Tree)
 * Medium
 * 一开始另写了个TreeNode，要清楚一点，不过要精简的话，代码还可以提取一下就是
 */
class Trie {

    public int count;
    public Trie[] child;

    /** Initialize your data structure here. */
    public Trie() {
        this.count = 0;
        this.child = new Trie[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie p = this;  // 这个this是需要记住的
        for (char c : word.toCharArray()) {
            if (p.child[c - 'a'] == null) {
                p.child[c - 'a'] = new Trie();
            }
            p = p.child[c - 'a'];
        }
        p.count++;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie p = this;
        for (char c : word.toCharArray()) {
            if (p.child[c - 'a'] == null) {
                return false;
            }
            p = p.child[c - 'a'];
        }
        return p.count > 0;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie p = this;
        for (char c : prefix.toCharArray()) {
            if (p.child[c - 'a'] == null) {
                return false;
            }
            p = p.child[c - 'a'];
        }
        return true;
    }
}

public class Solution {
    public static void main(String[] args) {
        // Your Trie object will be instantiated and called as such:
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 True
        System.out.println(trie.search("app"));     // 返回 False
        System.out.println(trie.startsWith("app")); // 返回 True
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 True
    }
}
