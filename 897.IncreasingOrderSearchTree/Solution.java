import java.util.*;

/**
 * 897. Increasing Order Search Tree
 * Easy
 */
public class Solution {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode fhead = new TreeNode();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode p = root, q = fhead;
        while (!stack.isEmpty()) {
            while (p.left != null) {
                stack.push(p.left);
                p = p.left;
            }
            p = stack.pop();
            q.right = p;
            q = q.right;
            q.left = null;
            if (p.right != null) {
                stack.push(p.right);
                p = p.right;
            }
        }
        return fhead.right;
    }

    private static TreeNode creatNode(Integer i) {
        return i == null ? null : new TreeNode(i);
    }

    private static TreeNode createTree(Integer[] nodes) {
        if (nodes == null || nodes.length == 0)
            return null;
        TreeNode root = creatNode(nodes[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (i < nodes.length) {
            TreeNode t = queue.remove();
            t.left = creatNode(nodes[i++]);
            if (t.left != null)
                queue.add(t.left);
            if (i == nodes.length)
                break;
            t.right = creatNode(nodes[i++]);
            if (t.right != null)
                queue.add(t.right);
        }
        return root;
    }

    private static void printTree(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            System.out.print((p == null ? "null" : p.val) + " ");
            if (p != null) {
                queue.add(p.left);
                queue.add(p.right);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Integer[] tree1 = { 5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9 };
        printTree(s.increasingBST(createTree(tree1)));
        
        Integer[] tree2 = { 5, 1, 7 };
        printTree(s.increasingBST(createTree(tree2)));

        Integer[] tree3 = { null };
        printTree(s.increasingBST(createTree(tree3)));
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
