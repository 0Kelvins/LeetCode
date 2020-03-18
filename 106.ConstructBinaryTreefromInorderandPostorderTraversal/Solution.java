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
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * 跟前一题思路一样，优化以后就能1ms
 */
class Solution {
    private TreeNode build(int[] inorder, int[] postorder, int instart, int inend, int postend,
            HashMap<Integer, Integer> map) {
        if (instart > inend || postend == -1)
            return null;
        TreeNode t = new TreeNode(postorder[postend]);
        int tindex = map.get(t.val);
        t.left = build(inorder, postorder, instart, tindex - 1, postend - (inend - tindex) - 1, map);
        t.right = build(inorder, postorder, tindex + 1, inend, postend - 1, map);
        return t;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        if (n == 0)
            return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put(inorder[i], i);
        return build(inorder, postorder, 0, n - 1, n - 1, map);
    }

    public void levelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode t = q.poll();
                if (t != null) {
                    System.out.print(t.val + " ");
                    q.offer(t.left);
                    q.offer(t.right);
                } else
                    System.out.print("null ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        File f = new File("input.txt");
        Scanner scan = new Scanner(f);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            int[] inorder = new int[n], postorder = new int[n];
            for (int i = 0; i < n; i++)
                inorder[i] = scan.nextInt();
            for (int i = 0; i < n; i++)
                postorder[i] = scan.nextInt();
            TreeNode t = s.buildTree(inorder, postorder);
            s.levelOrder(t);
        }
        scan.close();
    }
}