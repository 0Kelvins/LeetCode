import java.util.*;

/**
 * 257. Binary Tree Paths
 * Easy
 */
public class Solution {
    private void paths(TreeNode node, List<String> ans, String path) {
        if (node.left == null && node.right == null) {
            ans.add(path);
            return;
        }
        if (node.left != null) {
            paths(node.left, ans, path + "->" + String.valueOf(node.left.val));
        }
        if (node.right != null) {
            paths(node.right, ans, path + "->" + String.valueOf(node.right.val));
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        paths(root, ans, String.valueOf(root.val));
        return ans;
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
