import java.util.*;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 * Medium
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode visited = null;
        stack.push(root);
        TreeNode t = root;
        List<TreeNode> ancestors = null;
        while (!stack.isEmpty()) {
            while (t.left != null) {
                t = t.left;
                stack.push(t);
            }
            TreeNode x = stack.peek(); // check current node's right
            if (x.right != null && x.right != visited) {
                t = x.right;
                stack.push(t);
            } else {
                visited = stack.pop();
                if (visited.val == p.val || visited.val == q.val) {
                    if (ancestors == null) { // save first node's ancestors
                        ancestors = new ArrayList<>(stack);
                    } else { // got second node's ancestors
                        stack.push(visited);
                        break;
                    }
                }
            }
        }
        TreeNode anc = root;
        int i = ancestors.size();
        Iterator<TreeNode> j = stack.descendingIterator();
        while (i-- > 0 && j.hasNext()) {
            if (ancestors.get(i) == j.next()) {
                anc = ancestors.get(i);
            } else {
                break;
            }
        }
        return anc;
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}