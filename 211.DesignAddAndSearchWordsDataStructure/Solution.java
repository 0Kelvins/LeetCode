/**
 * 211. Design Add and Search Words Data Structure
 * Medium
 * 字典树
 */
class WordDictionary {

    private boolean isWord;
    private WordDictionary[] map;

    /** Initialize your data structure here. */
    public WordDictionary() {
        this.isWord = false;
        this.map = new WordDictionary[26];
    }
    
    public void addWord(String word) {
        WordDictionary t = this;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (t.map[i] == null) {
                t.map[i] = new WordDictionary();
            }
            t = t.map[i];
        }
        t.isWord = true;
    }

    private boolean dfs(char[] chars, int i, WordDictionary p) {
        if(i == chars.length) {
            return p.isWord;
        }
        char c = chars[i];
        if (c == '.') {
            for (int j = 0; j < p.map.length; j++) {
                if (p.map[j] != null && dfs(chars, i + 1, p.map[j])) {
                    return true;
                }
            }
        } else {
            int j = c - 'a';
            if (p.map[j] != null) {
                return dfs(chars, i + 1, p.map[j]);
            }
        }
        return false;
    }
    
    public boolean search(String word) {
        WordDictionary p = this;
        return dfs(word.toCharArray(), 0, p);
    }
}

public class Solution {

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
    }
}