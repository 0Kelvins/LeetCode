import java.io.*;
import java.util.*;

/**
 * 138. Copy List with Random Pointer
 */
class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Integer> map = new HashMap<>();
        Node fakeHead = new Node(-1), p = head, q = fakeHead;
        List<Node> newNodes = new ArrayList<>();
        int i = 0;
        while (p != null) {
            map.put(p, i++);
            Node t = new Node(p.val);
            newNodes.add(t);
            q.next = t;
            q = q.next;
            p = p.next;
        }
        p = head;
        q = fakeHead.next;
        while (p != null) {
            Integer random = map.get(p.random);
            q.random = random != null ? newNodes.get(random) : null;
            p = p.next;
            q = q.next;
        }
        return fakeHead.next;
    }

    private Node createList(Integer[][] input) {
        int n = input.length;
        if (n == 0)
            return null;
        Node[] nodes = new Node[n + 1];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(input[i][0]);
        }
        for (int i = 0; i < n; i++) {
            nodes[i].next = nodes[i + 1];
            nodes[i].random = input[i][1] != null ? nodes[input[i][1]] : null;
        }
        return nodes[0];
    }

    private void printList(Node head) {
        Map<Node, Integer> map = new HashMap<>();
        int i = 0;
        Node p = head;
        while (p != null) {
            map.put(p, i++);
            p = p.next;
        }
        p = head;
        System.out.print("[");
        while (p != null) {
            Integer random = map.get(p.random);
            System.out.print("[" + p.val + "," + random + "]");
            p = p.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        File f = new File("input.txt");
        Scanner scan = new Scanner(f);
        while (scan.hasNextLine()) {
            String in = scan.nextLine();
            String[] pairs = in.split(" ");
            if ("".equals(in) && in != null)
                pairs = new String[0];
            Integer[][] input = new Integer[pairs.length][2];
            for (int i = 0; i < pairs.length; i++) {
                String[] pair = pairs[i].split(",");
                input[i][0] = Integer.valueOf(pair[0]);
                input[i][1] = "null".equals(pair[1]) ? null : Integer.valueOf(pair[1]);
            }
            Node head = s.createList(input);
            Node copy = s.copyRandomList(head);
            s.printList(copy);
        }
        scan.close();
    }
}

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}