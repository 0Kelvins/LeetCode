/**
 * 206. Reverse Linked List
 * Easy
 */
public class Solution {
    
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode reverseList(ListNode head) {
        ListNode fhead = new ListNode();
        ListNode p = head, q;
        while (p != null) {
            q = p.next;
            p.next = fhead.next;
            fhead.next = p;
            p = q;
        }
        return fhead.next;
    }

    private ListNode createList(int[] nums) {
        ListNode fhead = new ListNode();
        ListNode p = fhead;
        for (int n : nums) {
            p.next = new ListNode(n);
            p = p.next;
        }
        return fhead.next;
    }

    public static void main(String[] args) {
        int[][] nums = { { 1, 2, 3, 4, 5 } };
        Solution s = new Solution();
        for (int[] ns : nums) {
            ListNode res = s.reverseList(s.createList(ns));
            while (res != null) {
                System.out.print(res.val + " ");
                res = res.next;
            }
            System.out.println();
        }
    }
}
