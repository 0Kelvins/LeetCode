import java.util.*;

/**
 * 297. Serialize and Deserialize Binary Tree
 * 常规BFS构建树操作，DFS也可以，因为有记录null节点，所以不会无法确定唯一树
 */
class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        List<String> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t = q.remove();
            if(t != null) {
                res.add(String.valueOf(t.val));
                q.add(t.left);
                q.add(t.right);
            } else {
                res.add("null");
            }
        }
        return String.join(",", res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if("".equals(data))
            return null;
        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for (int i = 1; i < nodes.length; i++) {
            TreeNode t = i % 2 == 1 ? q.peek() : q.remove();
            if ("null".equals(nodes[i]))
                continue;
            TreeNode c = new TreeNode(Integer.valueOf(nodes[i]));
            if (i % 2 == 1)
                t.left = c;
            else
                t.right = c;
            q.add(c);
        }
        return root;
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    // inorder
    private static void dfs(TreeNode node) {
        if(node == null)
            return;
        if(node.left != null)
            dfs(node.left);
        System.out.print(node.val + " ");
        if(node.right != null)
            dfs(node.right);
    }

    public static void main(String[] args) {
        List<TreeNode> nodes = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            nodes.add(new TreeNode(i));
        }
        TreeNode root = nodes.get(0);
        root.left = nodes.get(1);
        root.right = nodes.get(2);
        nodes.get(2).left = nodes.get(3);
        nodes.get(2).right = nodes.get(4);
        dfs(root);
        System.out.println();

        Codec ser = new Codec();
        Codec deser = new Codec();
        String s = ser.serialize(root);
        System.out.println(s);
        TreeNode ans = deser.deserialize(s);
        dfs(ans);
        System.out.println();
        System.out.println(ser.serialize(ans));
    }
}