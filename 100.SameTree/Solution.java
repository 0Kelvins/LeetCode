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
 * 100. Same Tree
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            TreeNode a = queue.poll();
            if (queue.isEmpty())
                return false;
            TreeNode b = queue.poll();
            if ((a == null || b == null) && a != b)
                return false;
            if (a == null)
                continue;
            if (a.val != b.val)
                return false;
            queue.offer(a.left);
            queue.offer(b.left);
            queue.offer(a.right);
            queue.offer(b.right);
        }
        return true;
    }

    private TreeNode createTree(String[] nums) {
        int n = nums.length;
        List<TreeNode> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            TreeNode node = null;
            if (!"null".equals(nums[i]))
                node = new TreeNode(Integer.parseInt(nums[i]));
            if (i != 0) {
                TreeNode parentNode = nodes.get((i - 1) / 2);
                if (i % 2 == 1)
                    parentNode.left = node;
                else
                    parentNode.right = node;
            }
            nodes.add(node);
        }
        return nodes.get(0);
    }

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        File f = new File("input.txt");
        Scanner scan = new Scanner(f);
        while (scan.hasNext()) {
            String[] aNodes = scan.next().split(",");
            String[] bNodes = scan.next().split(",");
            TreeNode p = s.createTree(aNodes);
            TreeNode q = s.createTree(bNodes);
            System.out.println(s.isSameTree(p, q));
        }
        scan.close();
    }
}