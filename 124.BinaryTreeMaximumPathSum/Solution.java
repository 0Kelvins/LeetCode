import java.io.*;
import java.util.*;

/**
 * 124. Binary Tree Maximum Path Sum
 * 有点难想到这么解。
 */
class Solution {
    private int max;

    private int maxPathDown(TreeNode root) {
        if (root == null)
            return 0;
        int l = Math.max(0, maxPathDown(root.left));
        int r = Math.max(0, maxPathDown(root.right));
        max = Math.max(max, l + r + root.val); // 路径的最高点可以加上两侧
        return Math.max(l, r) + root.val; // 子树路径只能走一边
    }

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxPathDown(root);
        return max;
    }

    public TreeNode createTree(String[] nums) {
        if (nums == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = null;
        for (int i = 0; i < nums.length; i++) {
            TreeNode t = null;
            if (!"null".equals(nums[i])) {
                t = new TreeNode(Integer.parseInt(nums[i]));
                queue.offer(t);
            }
            if (i != 0) {
                TreeNode parent = queue.peek();
                if (i % 2 == 0) {
                    parent.right = t;
                    queue.poll();
                } else
                    parent.left = t;
            } else
                root = t;
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        File f = new File("input.txt");
        Scanner scan = new Scanner(f);
        while (scan.hasNext()) {
            String[] nums = scan.nextLine().split(",");
            System.out.println(s.maxPathSum(s.createTree(nums)));
        }
        scan.close();
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}