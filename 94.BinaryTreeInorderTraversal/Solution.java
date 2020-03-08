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
 * 94. Binary Tree Inorder Traversal
 * 瞅了眼很久以前做的笔记。
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode t = root;
        while (t != null || !s.isEmpty()) {
            while (t != null) {
                s.push(t);
                t = t.left;
            }
            t = s.pop();
            result.add(t.val);
            t = t.right;
        }
        return result;
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
            List<Integer> result = s.inorderTraversal(root);
            result.forEach((r) -> System.out.print(r + " "));
            System.out.println();
        }
        scan.close();
    }
}