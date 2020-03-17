import java.io.*;
import java.util.*;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * 可以先用HashMap来映射节点值对应下标，来减少查找根节点中序下标时间
 * 直接用int变量标记边界比copyOfRange也可以省不少时间
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        int rootIndex = -1;
        for (int i = 0; i < n; i++) {
            if (inorder[i] == preorder[0]) {
                rootIndex = i;
                break;
            }
        }
        if (rootIndex != 0)
            root.left = buildTree(Arrays.copyOfRange(preorder, 1, rootIndex + 1),
                    Arrays.copyOfRange(inorder, 0, rootIndex));
        if (rootIndex != n - 1)
            root.right = buildTree(Arrays.copyOfRange(preorder, rootIndex + 1, n),
                    Arrays.copyOfRange(inorder, rootIndex + 1, n));
        return root;
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
            int[] preorder = new int[n], inorder = new int[n];
            for (int i = 0; i < n; i++)
                preorder[i] = scan.nextInt();
            for (int i = 0; i < n; i++)
                inorder[i] = scan.nextInt();
            TreeNode t = s.buildTree(preorder, inorder);
            s.levelOrder(t);
        }
        scan.close();
    }
}