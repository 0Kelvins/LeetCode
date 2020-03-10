// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/**
 * 92. Reverse Linked List II
*/
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n)
            return head;
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode p = fakeHead, t, q;
        int i = 1;
        while (i++ < m)
            p = p.next;
        t = p.next;
        while (i++ <= n) {
            q = p.next;
            p.next = t.next;
            t.next = t.next.next;
            p.next.next = q;
        }
        return fakeHead.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nodes = { 1, 2, 3, 4, 5, 6 };
        int m = 1, n = 6;
        ListNode fakeHead = new ListNode(-1);
        ListNode p = fakeHead;
        for (int i = 0; i < nodes.length; i++) {
            ListNode t = new ListNode(nodes[i]);
            p.next = t;
            p = p.next;
        }
        ListNode r = s.reverseBetween(fakeHead.next, m, n);
        while (r != null) {
            System.out.print(r.val + " ");
            r = r.next;
        }
    }
}