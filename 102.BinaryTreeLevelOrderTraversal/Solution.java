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
 * 102. Binary Tree Level Order Traversal
 * emmm，前面的二叉树题一直在写层序的输入之类的。
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1, j = 0;
        List<Integer> r = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode t = q.poll();
            r.add(t.val);
            i--;
            if (t.left != null) {
                q.offer(t.left);
                j++;
            }
            if (t.right != null) {
                q.offer(t.right);
                j++;
            }
            if (i == 0) {
                result.add(r);
                r = new ArrayList<>();
                i = j;
                j = 0;
            }
        }
        return result;
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
            List<List<Integer>> r = s.levelOrder(s.createTree(nums));
            for (List<Integer> i : r) {
                for (Integer j : i)
                    System.out.print(j + " ");
                System.out.println();
            }
        }
        scan.close();
    }
}