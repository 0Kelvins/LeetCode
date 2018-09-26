class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode s = new ListNode(0);
        s.next = head;
        ListNode t1 = s;
        ListNode t2 = s;
        while(n-- >= 0) {
            t1 = t1.next;
        }
        while (t1 != null) {
            t1 = t1.next;
            t2 = t2.next;
        }
        t2.next = t2.next.next;
        return s.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l = new ListNode(1);
        ListNode next = l;
        int i = 1;
        while (i++ < 6) {
            next.next = new ListNode(i);
            next = next.next;
        }
        next = l;
        while (next != null) {
            System.out.print(next.val + " ");
            next = next.next;
        }
        System.out.println();

        ListNode r = s.removeNthFromEnd(l, 1);

        while (r != null) {
            System.out.print(r.val + " ");
            r = r.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}