import java.util.*;

/**
 * 783. Minimum Distance Between BST Nodes
 * Easy
 * This question is the same as 530
 * 非递归中序遍历二叉搜索树得有序序列
 */
public class Solution {

    public int minDiffInBST(TreeNode root) {
        int min = Integer.MAX_VALUE;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode t = root;
        int pre = -1000000000;
        while (!stack.isEmpty() || t != null) {
            while (t != null) {
                stack.push(t);
                t = t.left;
            }
            if (!stack.isEmpty()) {
                t = stack.pop();
                min = Math.min(Math.abs(t.val - pre), min);
                pre = t.val;
                t = t.right;
            }
        }
        return min;
    }

    private static TreeNode createTree(Integer[] nodes) {
        if(nodes == null || nodes.length == 0 || nodes[0] == null)
            return null;
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nodes[0]);
        queue.add(root);
        int i = 1;
        while (i < nodes.length) {
            TreeNode t = queue.poll();
            if (nodes[i] != null) {
                t.left = new TreeNode(nodes[i]);
                queue.add(t.left);
            }
            i++;
            if (i < nodes.length && nodes[i] != null) {
                t.right = new TreeNode(nodes[i]);
                queue.add(t.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[][] trees = { { 4, 2, 6, 1, 3 }, { 1, 0, 48, null, null, 12, 49 },
                { 96, 12, null, null, 13, null, 52, 29 }, { 5, 1, 7 } };
        Solution s = new Solution();
        for (Integer[] nodes : trees) {
            TreeNode root = createTree(nodes);
            System.out.println(s.minDiffInBST(root));
        }
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
