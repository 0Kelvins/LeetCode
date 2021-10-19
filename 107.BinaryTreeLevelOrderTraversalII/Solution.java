import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 107. Binary Tree Level Order Traversal II
 * Medium
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        int n = 1, m = 0;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            level.add(t.val);
            if (t.left != null) {
                queue.offer(t.left);
                m++;
            }
            if (t.right != null) {
                queue.offer(t.right);
                m++;
            }
            if (--n == 0) {
                ans.add(0, new ArrayList<>(level));
                level = new ArrayList<>();
                n = m;
                m = 0;
            }
        }
        return ans;
    }
}


// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
