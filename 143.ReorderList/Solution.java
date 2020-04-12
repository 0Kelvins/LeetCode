/**
 * 143. Reorder List
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null)
            return;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow.next == null)
            return;
        ListNode p = slow.next.next, q = p;
        slow.next.next = null;
        while (p != null) {
            p = p.next;
            q.next = slow.next;
            slow.next = q;
            q = p;
        }
        p = head;
        q = slow.next;
        ListNode t1, t2;
        while (q != null) {
            t1 = p;
            t2 = q;
            p = p.next;
            q = q.next;
            t1.next = t2;
            t2.next = p;
        }
        slow.next = null;
    }

    private ListNode createList(int[] nums) {
        ListNode fakehead = new ListNode(-1), p = fakehead;
        for (int i : nums) {
            p.next = new ListNode(i);
            p = p.next;
        }
        return fakehead.next;
    }

    private void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] nums = { { 1, 2, 3, 4 }, { 1, 2, 3, 4, 5 }, { 1, 2 }, { 1, 2, 3 } };
        for (int[] i : nums) {
            ListNode head = s.createList(i);
            s.printList(head);
            s.reorderList(head);
            s.printList(head);
            System.out.println();
        }
    }
}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
