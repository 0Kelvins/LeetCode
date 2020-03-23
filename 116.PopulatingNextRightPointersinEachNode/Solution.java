import java.io.*;
import java.util.*;

/**
 * 116. Populating Next Right Pointers in Each Node
 */
class Solution {
    public Node connect(Node root) {
        if (root == null)
            return null;
        Node left = root.left, right = root.right;
        if (left != null) {
            left.next = right;
            connect(left);
            connect(right);
            while (left.right != null) {
                left = left.right;
                right = right.left;
                left.next = right;
            }
        }
        return root;
    }

    public Node createTree(String[] nums) {
        if (nums == null)
            return null;
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            Node t = null;
            if (!"null".equals(nums[i]))
                t = new Node(Integer.parseInt(nums[i]));
            nodes.add(t);
            if (i != 0) {
                Node parent = nodes.get((i - 1) / 2);
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

    public void traversalNext(Node root) {
        while (root != null) {
            Node t = root;
            while (t != null) {
                System.out.print(t.val + " ");
                t = t.next;
            }
            System.out.print("# ");
            root = root.left;
        }
    }

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        File f = new File("input.txt");
        Scanner scan = new Scanner(f);
        while (scan.hasNext()) {
            String[] nums = scan.nextLine().split(",");
            Node root = s.connect(s.createTree(nums));
            s.traversalNext(root);
        }
        scan.close();
    }
}

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
