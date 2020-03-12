import java.io.*;
import java.util.*;

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
 * 98. Validate Binary Search Tree
 * emmm，还是LeetCode熟悉的边界值味道。
 */
class Solution {
    private boolean isValid(TreeNode root, Long min, Long max) {
        if (root == null)
            return true;
        if (root.left != null && (root.left.val >= root.val || root.left.val <= min)
                || root.right != null && (root.right.val <= root.val || root.right.val >= max))
            return false;
        return isValid(root.left, min, Long.valueOf(root.val)) && isValid(root.right, Long.valueOf(root.val), max);
    }

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public TreeNode levelTraversalCreat(String[] nums) {
        if (null == nums || "null".equals(nums[0]))
            return null;
        Integer t = Integer.parseInt(nums[0]);
        TreeNode root = new TreeNode(t);
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        for (int i = 1; i < nums.length; i++) {
            if ("null".equals(nums[i]))
                continue;
            t = Integer.parseInt(nums[i]);
            TreeNode node = new TreeNode(t);
            TreeNode parentNode = nodes.get((i - 1) / 2);
            if (i % 2 == 1)
                parentNode.left = node;
            else
                parentNode.right = node;
            nodes.add(node);
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        File f = new File("input.txt");
        Scanner scan = new Scanner(f);
        Solution s = new Solution();
        while (scan.hasNext()) {
            String t = scan.nextLine();
            String[] nums = t.split(" ");
            TreeNode root = s.levelTraversalCreat(nums);
            System.out.println(s.isValidBST(root));
        }
        scan.close();
    }
}