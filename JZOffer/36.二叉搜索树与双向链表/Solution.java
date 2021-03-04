/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * Medium
 * 这题直接在网页提交的，记录一下
 * 二叉搜索树DFS得到有序序列
 */
public class Solution {

    private void dfs(Node node, List<Node> list) {
        if(node == null)
            return;
        dfs(node.left, list);
        list.add(node);
        dfs(node.right, list);
    }

    public Node treeToDoublyList(Node root) {
        if(root == null)
            return null;
        List<Node> list = new ArrayList<>();
        dfs(root, list);
        Node head, pre;
        head = list.get(0);
        pre = list.get(0);
        for(int i = 1; i < list.size(); i++) {
            Node t = list.get(i);
            pre.right = t;
            t.left = pre;
            pre = t;
        }
        pre.right = head;
        head.left = pre;
        return head;
    }
}

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};