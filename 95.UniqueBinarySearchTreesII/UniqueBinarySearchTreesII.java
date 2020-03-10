import java.util.*;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * 95. Unique Binary Search Trees II
 * leetcode上的大佬又多，解题又牛B，什么题都能DP.jpg🙄
 * 连这个二分递归我都看了半天，哭了😭DP自己就想不出来怎么实现
 * DP利用已求的n小的树列表来求子树，右子树的排列规律是和小的数字一样的，
 * 只需把右子树节点数对应n的树，对应的节点值加上当前中间点的值，即可得到右子树的树列表
 */
class Solution {
    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end)
            list.add(null);
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generate(start, i - 1); // 把左右子树可能的列表分别生成
            List<TreeNode> right = generate(i + 1, end);
            for (TreeNode lNode : left) {
                for (TreeNode rNode : right) {
                    TreeNode root = new TreeNode(i); // 再组装
                    root.left = lNode;
                    root.right = rNode;
                    list.add(root);
                }
            }
        }
        return list;
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();
        return generate(1, n);
    }

    public void levelOrderTraversal(TreeNode t, int n) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(t);
        int i = 0;
        while (!queue.isEmpty() && i < n) {
            TreeNode parent = queue.poll();
            if (parent != null) {
                System.out.print(parent.val + " ");
                queue.offer(parent.left);
                queue.offer(parent.right);
                i++;
            } else
                System.out.print("null ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            List<TreeNode> trees = s.generateTrees(n);
            trees.forEach((t) -> s.levelOrderTraversal(t, n));
        }
        scan.close();
    }
}