import java.io.*;
import java.util.*;

/**
 * 147. Insertion Sort List
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fakehead = new ListNode(Integer.MIN_VALUE);
        fakehead.next = head;
        ListNode orderTail = head, pre = fakehead;
        while (orderTail.next != null) {
            ListNode t = orderTail.next, q = t.val > pre.val ? pre : fakehead;
            orderTail.next = t.next;
            while (q != orderTail && q.next.val < t.val)
                q = q.next;
            t.next = q.next;
            q.next = t;
            pre = t;
            if (q == orderTail)
                orderTail = orderTail.next;
        }
        return fakehead.next;
    }

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        File f = new File("input.txt");
        Scanner scan = new Scanner(f);
        while (scan.hasNext()) {
            ListNode fakehead = new ListNode(-1), p = fakehead;
            String[] nums = scan.nextLine().split(" ");
            for (int i = 0; i < nums.length; i++) {
                p.next = new ListNode(Integer.parseInt(nums[i]));
                p = p.next;
            }
            ListNode r = s.insertionSortList(fakehead.next);
            while (r != null) {
                System.out.print(r.val + " ");
                r = r.next;
            }
            System.out.println();
        }
        scan.close();
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
