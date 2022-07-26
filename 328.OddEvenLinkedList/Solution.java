/**
 * 328. Odd Even Linked List
 * Medium
 */
public class Solution {

    public ListNode oddEvenList(ListNode head) {
        ListNode ohead = new ListNode(-1);
        ListNode ehead = new ListNode(-1);
        ListNode op = ohead, ep = ehead;
        int i = 0;
        while (head != null) {
            if (i % 2 == 0) {
                op.next = head;
                op = op.next;
            } else {
                ep.next = head;
                ep = ep.next;
            }
            head = head.next;
            i++;
        }
        op.next = ehead.next;
        ep.next = null;
        return ohead.next;
    }

    private ListNode createList(int[] arr) {
        ListNode fhead = new ListNode(-1);
        ListNode p = fhead;
        for (int i = 0; i < arr.length; i++) {
            ListNode t = new ListNode(arr[i]);
            p.next = t;
            p = p.next;
        }
        return fhead.next;
    }

    public static void main(String[] args) {
        int[][] nums = { { 1, 2, 3, 4, 5 }, { 2, 1, 3, 5, 6, 4, 7 } };
        Solution sol = new Solution();
        for (int[] arr : nums) {
            ListNode head = sol.createList(arr);
            ListNode r = sol.oddEvenList(head);
            while (r != null) {
                System.out.print(r.val + " ");
                r = r.next;
            }
            System.out.println();
        }
    }
}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}