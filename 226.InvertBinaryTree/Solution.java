/**
 * 226. Invert Binary Tree
 * Easy
 */
public class Solution {

    private void postOrder(TreeNode node) {
        if (node.left != null) {
            postOrder(node.left);
        }
        if (node.right != null) {
            postOrder(node.right);
        }
        TreeNode t = node.left;
        node.left = node.right;
        node.right = t;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        postOrder(root);
        return root;
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
