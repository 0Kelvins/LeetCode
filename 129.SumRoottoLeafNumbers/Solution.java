import java.io.*;
import java.util.*;

/**
 * 129. Sum Root to Leaf Numbers
 */
class Solution {
    private int sumNumber(TreeNode t, int preVal) {
        int sum = 0;
        preVal = preVal * 10 + t.val;
        if (t.left == null && t.right == null)
            sum += preVal;
        else {
            if (t.left != null)
                sum += sumNumber(t.left, preVal);
            if (t.right != null)
                sum += sumNumber(t.right, preVal);
        }
        return sum;
    }

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        return sumNumber(root, 0);
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
            System.out.println(s.sumNumbers(s.createTree(nums)));
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
