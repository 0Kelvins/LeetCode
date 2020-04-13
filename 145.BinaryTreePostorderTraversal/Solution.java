import java.util.*;
import java.io.*;

/**
 * 145. Binary Tree Postorder Traversal
 * 在不修改原树，真正后续遍历的前提下，这么写应该是比较简洁的了吧
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode t = stack.peek();
                if (t.right == pre || t.right == null) {
                    stack.pop();
                    result.add(t.val);
                    pre = t;
                } else
                    root = t.right;
            }
        }
        return result;
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
            System.out.println(s.postorderTraversal(s.createTree(nums)).toString());
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
