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
 * 113. Path Sum II
 * emmm，非递归算法比递归还慢的样子呢。
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> r = new ArrayList<>();
        if (root == null)
            return r;
        Stack<TreeNode> s = new Stack<>();
        TreeNode pre = null;
        int pathWeight = 0;
        while (!s.isEmpty() || root != null) {
            while (root != null) { // 向最左
                pathWeight += root.val;
                s.push(root);
                root = root.left;
            }
            if (!s.isEmpty()) {
                root = s.peek();
                if (root.right != null && root.right != pre) { // 向未访问的右
                    root = root.right;
                    pathWeight += root.val;
                    s.push(root);
                    root = root.left;
                } else { // 访问
                    if (root.left == null && root.right == null && pathWeight == sum) {
                        List<Integer> path = new ArrayList<>();
                        for (TreeNode i : s)
                            path.add(i.val);
                        r.add(path);
                    }
                    pathWeight -= root.val;
                    pre = s.pop();
                    root = null;
                }
            }
        }
        return r;
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
            int sum = scan.nextInt();
            String[] nums = scan.next().split(",");
            List<List<Integer>> r = s.pathSum(s.createTree(nums), sum);
            for (List<Integer> i : r) {
                for (Integer j : i)
                    System.out.print(j + " ");
                System.out.println();
            }
        }
        scan.close();
    }
}