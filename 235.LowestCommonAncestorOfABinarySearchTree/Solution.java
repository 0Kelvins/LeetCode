/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * Easy
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            } else if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            } else {
                break;
            }
        }
        return ancestor;
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}