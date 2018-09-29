/**
 * 25. Reverse Nodes in k-Group
*/
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) return head;
        ListNode t = new ListNode(0), s = t;
        t.next = head;
        while (true) {
            ListNode prev = s, cur, tail = prev;
            s = prev.next;
            for (int i = 0; i < k && tail != null; i++)
                tail = tail.next;
            if (tail == null) break;
            for (int i = 0; i < k-1; i++) {
                cur = prev.next;
                prev.next = cur.next;
                cur.next = tail.next;
                tail.next = cur;
            }
        }
        return t.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] a = {1, 2, 3, 4, 5};
        ListNode list = new ListNode(a);
        list.printList();
        
        ListNode r = s.reverseKGroup(list, 3);

        r.printList();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) { val = x; }

    ListNode(int[] a) {
        this.val = a[0];
        ListNode t = null;
        if (a.length > 1) {
            this.next = new ListNode(a[1]);
            t = this.next;
        }
        int i = 2;
        while (i < a.length) {
            t.next = new ListNode(a[i++]);
            t = t.next;
        }
    }

    public void printList() {
        ListNode t = this;
        while (t != null) {
            System.out.print(t.val + " ");
            t = t.next;
        }
        System.out.println();
    }
}