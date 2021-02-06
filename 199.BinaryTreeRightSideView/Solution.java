import java.util.*;

/**
 * 199. Binary Tree Right Side View
 * Medium
 * 层次遍历，注意记录层非空节点数量即可
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> right = new ArrayList<>();
        if (root == null)
            return right;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int n = 1, i = 0, m = 0;    // n：当前层非空节点数，i：当前层遍历节点数，m：下一层非空节点数
        while (!q.isEmpty()) {
            TreeNode t = q.remove();
            if(t.left != null) {
                q.add(t.left);
                m++;
            }
            if (t.right != null) {
                q.add(t.right);
                m++;
            }
            if (++i == n) {
                right.add(t.val);
                n = m;
                i = m = 0;
            }

        }
        return right;
    }

    private TreeNode createTree(Integer[] nodes) {
        if (nodes == null || nodes.length == 0)
            return null;
        TreeNode[] tree = new TreeNode[nodes.length];
        int i = nodes.length;
        while(i-- > nodes.length / 2) {
            tree[i] = nodes[i] == null ? null : new TreeNode(nodes[i]);
        }
        while (i >= 0) {
            tree[i] = nodes[i] == null ? null : new TreeNode(nodes[i], tree[i * 2 + 1], tree[(i + 1) * 2]);
            i--;
        }
        
        return tree[0];
    }

    public static void main(String[] args) {
        Integer[][] nodes = { { 1, 2, 3, null, 5, null, 4 }, { 1, 2, 3, null, 5, null, null } };
        Solution s = new Solution();
        for (Integer[] n : nodes) {
            TreeNode t = s.createTree(n);
            List<Integer> r = s.rightSideView(t);
            r.forEach((e) -> System.out.print(e + " "));
            System.out.println();
        }
    }
}

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