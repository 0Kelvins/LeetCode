import java.util.*;

/**
 * 133. Clone Graph
 * 这题BFS做出来不难，DFS要难想点，还有输入输出自己写有点麻烦
 * vscode对同名文件debug问题又没折腾好，还是只能每次debug前clean workspace，辛苦写的脚本又废了，哎
 */
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        Map<Integer, Node> map = new HashMap<>();
        Node newNode = new Node(node.val);
        map.put(newNode.val, newNode);
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        boolean[] visited = new boolean[101];
        visited[node.val] = true;
        while (!q.isEmpty()) {
            Node t = q.poll();
            for (int i = 0; i < t.neighbors.size(); i++) {
                Node k = t.neighbors.get(i);
                if (!map.containsKey(k.val)) {
                    Node n = new Node(k.val);
                    map.put(n.val, n);
                }
                if (!visited[k.val]) {
                    q.offer(k);
                    visited[k.val] = true;
                }
                map.get(t.val).neighbors.add(map.get(k.val));
            }
        }
        return newNode;
    }

    private void nodePrint(Node node) {
        if (node == null) {
            System.out.println("[]");
            return;
        }
        Map<Integer, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        boolean[] visited = new boolean[101];
        while (!q.isEmpty()) {
            Node t = q.poll();
            visited[t.val] = true;
            if (!map.containsKey(t.val))
                map.put(t.val, t);
            for (int i = 0; i < t.neighbors.size(); i++) {
                if (!visited[t.neighbors.get(i).val])
                    q.offer(t.neighbors.get(i));
            }
        }
        Object[] keys = map.keySet().toArray();
        Arrays.sort(keys);
        List<List<Integer>> list = new ArrayList<>();
        for (Object k : keys) {
            Node t = map.get(k);
            List<Integer> neighbors = new ArrayList<>();
            for (Node n : t.neighbors)
                neighbors.add(n.val);
            list.add(neighbors);
        }
        System.out.println(list.toString());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][][] adjList = { { { 2, 4 }, { 1, 3 }, { 2, 4 }, { 1, 3 } }, { {} }, {}, { { 2 }, { 1 } } };
        for (int i = 0; i < adjList.length; i++) {
            Node[] nodes = new Node[adjList[i].length];
            for (int j = 0; j < adjList[i].length; j++)
                nodes[j] = new Node(j + 1);
            for (int j = 0; j < adjList[i].length; j++) {
                for (int k = 0; k < adjList[i][j].length; k++)
                    nodes[j].neighbors.add(nodes[adjList[i][j][k] - 1]);
            }
            Node newNode = null;
            if (adjList[i].length > 0)
                newNode = s.cloneGraph(nodes[0]);
            else
                newNode = s.cloneGraph(null);
            s.nodePrint(newNode);
        }
    }
}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}