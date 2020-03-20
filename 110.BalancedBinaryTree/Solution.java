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
 * 110. Balanced Binary Tree
 * 这题虽然简单，但是还是复习一下平衡二叉树的知识好
 */
class Solution {
    private boolean isBalanced = true;

    private int dfs(TreeNode root) {
        if (root == null || !isBalanced) // 已失衡剪枝
            return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        if (Math.abs(l - r) > 1)
            isBalanced = false;
        return l > r ? l + 1 : r + 1;
    }

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return isBalanced;
    }

    public TreeNode createTree(String[] nums) {
        if (nums == null)
            return null;
        List<TreeNode> nodes = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            TreeNode t = null;
            if (!"null".equals(nums[i]))
                t = new TreeNode(Integer.parseInt(nums[i]));
            nodes.add(t);
            if (i != 0) {
                TreeNode parent = nodes.get((i - 1) / 2);
                if (parent == null)
                    continue;
                if (i % 2 == 0)
                    parent.right = t;
                else
                    parent.left = t;
            }
        }
        return nodes.get(0);
    }

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        File f = new File("input.txt");
        Scanner scan = new Scanner(f);
        while (scan.hasNext()) {
            String[] nums = scan.nextLine().split(",");
            System.out.println(s.isBalanced(s.createTree(nums)));
        }
        scan.close();
    }
}