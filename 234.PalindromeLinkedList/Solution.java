/**
 * 234. Palindrome Linked List
 * Easy
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fhead = new ListNode(-1);
        ListNode slow = head, fast = head, t;
        boolean isOdd = false;
        while (slow != null && fast != null) {
            t = slow;
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            } else {
                isOdd = true;
            }
            t.next = fhead.next;
            fhead.next = t;
        }
        ListNode p = fhead.next, q = slow;
        if (isOdd) {
            p = p.next;
        }
        while (p != null && q != null) {
            if (p.val != q.val) {
                break;
            }
            p = p.next;
            q = q.next;
        }
        return p == null && q == null;
    }
    
    public static void main(String[] args) {
        int[][] nums = { { 1, 2, 2, 1 }, { 1 }, { 1, 2 } };
        Solution s = new Solution();
        for (int i = 0; i < nums.length; i++) {
            ListNode head = new ListNode(nums[i][0]), p = head;
            for (int j = 1; j < nums[i].length; j++) {
                p.next = new ListNode(nums[i][j]);
                p = p.next;
            }
            System.out.println(s.isPalindrome(head));
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