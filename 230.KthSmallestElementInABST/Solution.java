import java.util.Deque;
import java.util.LinkedList;

/**
 * 230. Kth Smallest Element in a BST
 * Medium
 */
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode p = root;
        int i = 0;
        while (!stack.isEmpty()) {
            while (p.left != null) {
                p = p.left;
                stack.push(p);
            }
            TreeNode t = stack.pop();
            i++;
            if (i == k) {
                return t.val;
            }
            if (t.right != null) {
                p = t.right;
                stack.push(p);
            }
        }
        return p.val;
    }

    private static TreeNode createTree(Integer[] nodes) {
        if (nodes.length == 0) {
            return null;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nodes[0]);
        queue.offer(root);
        int i = 1;
        while (i < nodes.length) {
            TreeNode p = queue.poll();
            if (p != null) {
                p.left = nodes[i] == null ? null : new TreeNode(nodes[i]);
                queue.add(p.left);
                if (++i < nodes.length) {
                    p.right = nodes[i] == null ? null : new TreeNode(nodes[i]);
                    queue.add(p.right);
                }
                i++;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[][] nodes = { { 3, 1, 4, null, 2 }, { 5, 3, 6, 2, 4, null, null, 1 }, { 1, null, 2 } };
        int[] k = { 1, 3, 2 };
        Solution s = new Solution();
        for (int i = 0; i < k.length; i++) {
            TreeNode root = createTree(nodes[i]);
            System.out.println(s.kthSmallest(root, k[i]));
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