import java.io.*;
import java.util.*;

/**
 * 148. Sort List
 */
class Solution {
    // 单链表快排
    private void partition(ListNode head, ListNode tail) {
        if (head == tail)
            return;
        ListNode pivot = quickSort(head, tail);
        partition(head, pivot);
        partition(pivot.next, tail);
    }

    private ListNode quickSort(ListNode head, ListNode tail) {
        ListNode slow = head, fast = head.next;
        while (fast != tail) {
            if (fast.val < head.val) {
                slow = slow.next;
                swap(slow, fast);
            }
            fast = fast.next;
        }
        swap(slow, head);
        return slow;
    }

    private void swap(ListNode a, ListNode b) {
        int t = a.val;
        a.val = b.val;
        b.val = t;
    }

    public ListNode sortList(ListNode head) {
        ListNode fakeHead = new ListNode(Integer.MIN_VALUE);
        fakeHead.next = head;
        partition(fakeHead, null);
        return fakeHead.next;
    }

    // 归并排序
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        ListNode left = sortList2(head);
        ListNode right = sortList2(head2);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
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
            ListNode r = s.sortList2(fakehead.next);
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
