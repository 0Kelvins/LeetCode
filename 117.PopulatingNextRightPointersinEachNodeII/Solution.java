import java.io.*;
import java.util.*;

/**
 * 117. Populating Next Right Pointers in Each Node II
 * 利用next实现无队列层序遍历
 */
class Solution {
    public Node connect(Node root) {
        if (root == null)
            return null;
        Node t = root;
        Node head = new Node(-1);
        Node p = head;
        while (t != null) {
            while (t != null) {
                if (t.left != null) {
                    p.next = t.left;
                    p = p.next;
                }
                if (t.right != null) {
                    p.next = t.right;
                    p = p.next;
                }
                t = t.next;
            }
            t = head.next;
            head.next = null;
            p = head;
        }
        return root;
    }

    public Node createTree(String[] nums) {
        if (nums == null)
            return null;
        Queue<Node> queue = new LinkedList<>();
        Node root = null;
        for (int i = 0; i < nums.length; i++) {
            Node t = null;
            if (!"null".equals(nums[i]))
                t = new Node(Integer.parseInt(nums[i]));
            queue.offer(t);
            if (i != 0) {
                Node parent = null;
                while (queue.peek() == null)
                    queue.poll();
                parent = queue.peek();
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

    public void traversalNext(Node root) {
        while (root != null) {
            Node nextFirst = null;
            Node t = root;
            while (t != null) {
                System.out.print(t.val + " ");
                if (nextFirst == null) {
                    if (t.left != null)
                        nextFirst = t.left;
                    else if (t.right != null)
                        nextFirst = t.right;
                }
                t = t.next;
            }
            System.out.print("# ");
            root = nextFirst;
        }
        System.out.println();
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
