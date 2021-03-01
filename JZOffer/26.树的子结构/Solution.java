import java.util.*;

/**
 * 剑指 Offer 26. 树的子结构
 * Medium
 * 这题DFS先比较根结点，匹配后再比较子树
 * 由于树可能是不完全二叉树所以遍历后序列比较并不方便
 */
public class Solution {

    private boolean isSameStructure(TreeNode A, TreeNode B) {
        if (A == null && B != null) {
            // System.out.println("A:" + (A != null ? A.val : "null"));
            // System.out.println("B:" + (B != null ? B.val : "null"));
            return false;
        }
        if (A != null && B == null || A == null && B == null)   // 在子树比较时，B可以是A的子集，所以B可空
            return true;
        if (A.val == B.val)
            return isSameStructure(A.left, B.left) && isSameStructure(A.right, B.right);
        // System.out.println("A!=B:" + A.val + "," + B.val);
        return false;
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A != null && B == null || A == null && B != null)
            return false;
        if (A == null && B == null)
            return true;
        boolean inLeft = true, inRight = true;
        if(A.val != B.val || !isSameStructure(A, B)) {  // 寻找相同根结点，并比较子树
            inLeft = A.left != null ? isSubStructure(A.left, B) : false;
            inRight = A.right != null ? isSubStructure(A.right, B) : false;
        }
        return inLeft || inRight;
    }

    private TreeNode createTree(Integer[] nodes) {
        if (nodes == null || nodes.length == 0)
            return null;
        TreeNode root = creatNode(nodes[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (i < nodes.length) {
            TreeNode t = queue.remove();
            t.left = creatNode(nodes[i++]);
            queue.add(t.left);
            if (i == nodes.length)
                break;
            t.right = creatNode(nodes[i++]);
            queue.add(t.right);
        }
        return root;
    }

    private TreeNode creatNode(Integer i) {
        return i == null ? null : new TreeNode(i);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Integer[][] as = { { 1, 2, 3 }, { 3, 4, 5, 1, 2 }, { 3 }, { 3, 4, 5, 1, 2 }, { 3, 4, 5, 1, 2 } };
        Integer[][] bs = { { 3, 1 }, { 4, 1 }, {}, {4, null, 2}, {3, 4, null, 1, 2} };
        for (int i = 0; i < as.length; i++) {
            TreeNode A = s.createTree(as[i]);
            TreeNode B = s.createTree(bs[i]);
            System.out.println(s.isSubStructure(A, B));
        }
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}