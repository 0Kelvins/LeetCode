/**
 * 222. Count Complete Tree Nodes
 * Medium
 * 二分查找+位运算，不难想，就是边边角角写起来有点麻烦
 */
public class Solution {

    // 将二叉树01编码，根为高位，叶为低位，则最后一行节点即对应第n个数即可按位搜索
    private int findLast(TreeNode node, int height, int num, int depth) {
        if (node == null) {
            return depth - 1;
        }
        if (depth == height) {
            return depth;
        }
        int direct = (num >> (height - depth - 1)) & 1; // 对应层搜索方向
        return direct == 0 ? findLast(node.left, height, num, depth + 1) : findLast(node.right, height, num, depth + 1);
    }

    public int countNodes(TreeNode root) {
        TreeNode p = root;
        int height = 0;
        while (p != null) { // 先求树高度
            height++;
            p = p.left;
        }
        if(height < 2) 
            return height;
        int[] h = new int[1 << (height - 1)];   // 最后一行高度
        int left = 0, right = (1 << (height - 1)) - 1;  // 二分查找，left、right：行左右指针
        while (left <= right) {
            int mid = (left + right) / 2;
            h[mid] = findLast(root, height, mid, 1);
            if (h[mid] == height) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        int count = 0;  // 利用完全二叉树性质计算前面层节点数
        for (int i = 0; i < height - 1; i++) {
            count += 1 << i;
        }
        count += left;
        return count;
    }

    private static TreeNode createTree(int[] nodes) {
        if (nodes == null || nodes.length == 0) {
            return null;
        }
        TreeNode[] tree = new TreeNode[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            tree[i] = new TreeNode(nodes[i]);
        }
        for (int i = 0;; i++) {
            if ((i + 1) * 2 - 1 >= nodes.length) {
                break;
            }
            tree[i].left = tree[(i + 1) * 2 - 1];
            if ((i + 1) * 2 >= nodes.length) {
                break;
            }
            tree[i].right = tree[(i + 1) * 2];
        }
        return tree[0];
    }

    public static void main(String[] args) {
        int[][] nodes = {{ 1, 2, 3, 4, 5 }, { 1, 2, 3, 4, 5, 6 }, {}, { 1 }};
        Solution s = new Solution();
        for (int[] ns : nodes) {
            System.out.println(s.countNodes(createTree(ns)));
        }
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
