/**
 * 530. Minimum Absolute Difference in BST
 * Easy
 * This question is the same as 783
 * 递归中序遍历二叉搜索树得有序序列
 */
public class Solution {

    private int pre;
    private int min;

    private void inOrder(TreeNode node) {
        if(node.left != null)
            inOrder(node.left);
        if (pre == -1) {
            pre = node.val;
        } else {
            min = Math.min(Math.abs(node.val - pre), min);
            pre = node.val;
        }
        if(node.right != null)
            inOrder(node.right);
    }

    public int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        pre = -1;
        inOrder(root);
        return min;
    }
}
