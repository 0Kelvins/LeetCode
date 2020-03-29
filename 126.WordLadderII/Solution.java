import java.io.*;
import java.util.*;

/**
 * 126. Word Ladder II
 * 先BFS缩小范围，把最短长度内每个路径节点的下一个节点记录下来，用作DFS的基础数据
 * 还可以用双向BFS来优化。这两题有点难。
 */
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        Map<String, List<String>> nexts = bfs(beginWord, endWord, wordList); // BFS得到缩小的next树
        dfs(beginWord, endWord, nexts, result, path);
        return result;
    }

    private Map<String, List<String>> bfs(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> nexts = new HashMap<>();
        Set<String> words = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>(); // 已访问的节点
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.add(beginWord);
        boolean found = false;
        while (!queue.isEmpty() && !found) {
            int n = queue.size();
            Set<String> nextVisit = new HashSet<>(); // 下一层节点
            for (int i = 0; i < n; i++) {
                String cur = queue.poll();
                for (int j = 0; j < cur.length(); j++) {
                    StringBuilder newWord = new StringBuilder(cur);
                    for (char k = 'a'; k <= 'z'; k++) {
                        newWord.setCharAt(j, k);
                        String next = newWord.toString();
                        if (!words.contains(next))
                            continue;
                        if (next.equals(endWord)) // 访问到最短路径层
                            found = true;
                        if (!visited.contains(next)) {
                            if (!nexts.containsKey(cur))
                                nexts.put(cur, new ArrayList<>());
                            nexts.get(cur).add(next);
                            if (!nextVisit.contains(next)) {
                                queue.offer(next);
                                nextVisit.add(next);
                            }
                        }
                    }
                }
            }
            visited.addAll(nextVisit);
        }
        return nexts;
    }

    private void dfs(String beginWord, String endWord, Map<String, List<String>> nexts, List<List<String>> result,
            List<String> path) {
        path.add(beginWord);
        if (endWord.equals(beginWord))
            result.add(new ArrayList<>(path));
        else if (nexts.containsKey(beginWord)) {
            for (String next : nexts.get(beginWord))
                dfs(next, endWord, nexts, result, path);
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        File f = new File("input.txt");
        Scanner scan = new Scanner(f);
        while (scan.hasNext()) {
            String beginWord = scan.next();
            String endWord = scan.next();
            String[] words = scan.next().split(",");
            List<List<String>> r = s.findLadders(beginWord, endWord, Arrays.asList(words));
            for (List<String> i : r) {
                for (String j : i)
                    System.out.print(j + " ");
                System.out.println();
            }
            System.out.println();
        }
        scan.close();
    }
}