import java.util.*;
import java.io.*;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * 99. Recover Binary Search Tree
 * 这里递归好像还更好点？毕竟栈也是O(n)的空间，尾递归可能还更小空间
 * 效率好像也没有更好些，不过不需要全局变量就是
 */
class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode pre = null, m1 = null, m2 = null;
        Stack<TreeNode> s = new Stack<>();
        while (!s.isEmpty() || root != null) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            if (!s.isEmpty()) {
                root = s.pop();
                if (pre != null) {
                    if (m1 == null && pre.val > root.val)
                        m1 = pre;
                    if (m1 != null && root.val < pre.val)
                        m2 = root;
                }
                pre = root;
                root = root.right;
            }
        }
        if (m1 != null && m2 != null) {
            int t = m1.val;
            m1.val = m2.val;
            m2.val = t;
        }
    }

    private TreeNode preorderCreatTree(TreeNode t, Scanner scan) {
        char c = scan.next().charAt(0);
        if (c == '#') {
            t = null;
        } else {
            t = new TreeNode(c - '0');
            t.left = preorderCreatTree(t, scan);
            t.right = preorderCreatTree(t, scan);
        }
        return t;
    }

    private void inorderTraversal(TreeNode t) {
        if (t != null) {
            inorderTraversal(t.left);
            System.out.print(t.val);
            inorderTraversal(t.right);
        }
    }

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        File f = new File("input.txt");
        java.util.Scanner scan = new Scanner(f);
        while (scan.hasNext()) {
            TreeNode t = null;
            t = s.preorderCreatTree(t, scan);
            s.inorderTraversal(t);
            System.out.print(" ");
            s.recoverTree(t);
            s.inorderTraversal(t);
            System.out.println();
        }
    }
}