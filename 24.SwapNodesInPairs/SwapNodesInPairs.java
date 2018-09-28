/**
 * 24. Swap Nodes in Pairs
 * easy
*/
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode t = new ListNode(0);
        ListNode l1, l2, r;
        r = t;

        while (head != null && head.next != null) {
            l1 = head;
            l2 = head.next;

            t.next = l2;    // 插入第二个node
            t = t.next;
            head = l2.next; // 链表头指向第三个node

            t.next = l1;    // 插入第一个node
            t = t.next;
            t.next = head;  // 把链表头插在最后
        }
        return r.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] a = {1, 2, 3, 4, 5};
        ListNode list = new ListNode(a);
        list.printList();
        
        ListNode r = s.swapPairs(list);

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