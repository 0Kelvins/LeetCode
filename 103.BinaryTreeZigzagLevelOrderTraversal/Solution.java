import java.util.*;
import java.io.*;

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
 * 103. Binary Tree Zigzag Level Order Traversal
 * 这题的层序遍历写法虽然效率差不多，但是要舒服不少
 * DFS似乎更快，可能是测试点有比较深的树
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean z = false;
        while (!q.isEmpty()) {
            List<Integer> r = new ArrayList<>();
            int n = q.size();// 当前层节点数
            for (int i = 0; i < n; i++) {
                TreeNode t = q.poll();
                if (z == false)
                    r.add(t.val);
                else
                    r.add(0, t.val);
                if (t.left != null)
                    q.offer(t.left);
                if (t.right != null)
                    q.offer(t.right);
            }
            result.add(r);
            z = !z;
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
            List<List<Integer>> r = s.zigzagLevelOrder(s.createTree(nums));
            for (List<Integer> i : r) {
                for (Integer j : i)
                    System.out.print(j + " ");
                System.out.println();
            }
        }
        scan.close();
    }
}