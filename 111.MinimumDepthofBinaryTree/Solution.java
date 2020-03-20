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
 * 111. Minimum Depth of Binary Tree
 * 简单就多做一题
 */
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int min = 1;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode t = queue.poll();
                if (t != null) {
                    if (t.left == null && t.right == null)
                        return min;
                    queue.offer(t.left);
                    queue.offer(t.right);
                }
            }
            min++;
        }
        return min;
    }

    public TreeNode createTree(String[] nums) {
        List<TreeNode> nodes = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            TreeNode t = null;
            if (!"null".equals(nums[i]))
                t = new TreeNode(Integer.parseInt(nums[i]));
            nodes.add(t);
            if (i != 0) {
                if (i % 2 == 0)
                    nodes.get((i - 1) / 2).right = t;
                else
                    nodes.get((i - 1) / 2).left = t;
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
            System.out.println(s.minDepth(s.createTree(nums)));
        }
        scan.close();
    }
}