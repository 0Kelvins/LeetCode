/**
 * 23. Merge k Sorted Lists
 * 使用归并方法，利用Priority Queue小顶堆特性会更简单
*/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int f = 1;
        while (f < lists.length) {  // 归并逻辑
            for (int i = 0; i < lists.length - f; i += f) {
                lists[i] = mergeTwoLists(lists[i], lists[i+f]);
            }
            f *= 2;
        }
        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode r = null;
        if (l1.val < l2.val) {
            r = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            r = new ListNode(l2.val);
            l2 = l2.next;
        }
        
        ListNode t = r;

        while (l1 != null && l2 != null) {
            while (l1 != null && l2 != null && l1.val <= l2.val) {
                t.next = new ListNode(l1.val);
                l1 = l1.next;
                t = t.next;
            }
            while (l1 != null && l2 != null && l1.val > l2.val) {
                t.next = new ListNode(l2.val);
                l2 = l2.next;
                t = t.next;
            }
        }

        t.next = l1 != null ? l1 : l2;

        return r;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] a = {1, 3, 4};
        int[] b = {2, 3, 4};
        int[] c = {2, 3, 4, 9, 11};
        
        ListNode[] list = new ListNode[3];
        list[0] = new ListNode(a);
        list[1] = new ListNode(b);
        list[2] = new ListNode(c);

        for (int i = 0; i < list.length; i++) {
            list[i].printList();
        }
        
        ListNode r = s.mergeKLists(list);

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