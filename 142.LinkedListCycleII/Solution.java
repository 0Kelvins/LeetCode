/**
 * 142. Linked List Cycle II
 * 哈希表的方法很简单，主要是双指针的方法如何找到环入口，需要数学证明参考官方题解
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
        if (fast == null || fast.next == null)
            return null;
        ListNode p = head, q = fast;
        while (p != q) {
            p = p.next;
            q = q.next;
        }
        return p;
    }

    private ListNode createList(int[] nums, int pos) {
        ListNode fakehead = new ListNode(-1), p = fakehead, cycleBeginNode = null;
        for (int i = 0; i < nums.length; i++) {
            ListNode t = new ListNode(nums[i]);
            p.next = t;
            p = p.next;
            if (pos == i)
                cycleBeginNode = t;
        }
        p.next = cycleBeginNode;
        return fakehead.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] nums = { { 3, 2, 0, -4 }, { 1, 2 }, { 1 }, { 1 }, { 1, 2 }, { -21, 10, 17, 8, 4, 26, 5, 35, 33, -7, -16,
                27, -12, 6, 29, -12, 5, 9, 20, 14, 14, 2, 13, -24, 21, 23, -21, 5 } };
        int[] pos = { 1, 0, -1, 0, -1, 24 };
        for (int i = 0; i < pos.length; i++) {
            ListNode head = s.createList(nums[i], pos[i]);
            ListNode b = s.detectCycle(head);
            if (b != null) {
                int index = 0;
                while (b != head) {
                    head = head.next;
                    index++;
                }
                System.out.println(index);
            } else
                System.out.println("null");

        }
    }
}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
