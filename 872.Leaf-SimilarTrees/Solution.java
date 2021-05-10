import java.util.Deque;
import java.util.LinkedList;

/**
 * 872.Leaf-Similar Trees
 * 先序遍历存储叶节点到队列，比较剪枝
 */
public class Solution {

    private Deque<Integer> queue;

    private void dfs(TreeNode node) {
        if (node.left == null && node.right == null) {
            queue.offer(node.val);
        } else {
            if (node.left != null) {
                dfs(node.left);
            }
            if (node.right != null) {
                dfs(node.right);
            }
        }
    }

    private boolean compareLeaves(TreeNode node) {
        if (node.left == null && node.right == null) {
            Integer t = queue.poll();
            if (t == null) {
                return false;
            } else {
                return t == node.val;
            }
        } else {
            boolean flag = true;
            if (node.left != null) {
                flag = compareLeaves(node.left);
            }
            if (flag && node.right != null) {
                flag = compareLeaves(node.right);
            }
            return flag;
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        queue = new LinkedList<>();
        dfs(root1);
        return compareLeaves(root2) && queue.isEmpty();
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}