import java.io.*;
import java.util.*;

/**
 * 160. Intersection of Two Linked Lists
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        int lenA = 0, lenB = 0;
        while (p != null) {
            p = p.next;
            lenA++;
        }
        while (q != null) {
            q = q.next;
            lenB++;
        }
        p = lenA > lenB ? headA : headB;
        int t = Math.abs(lenA - lenB);
        while (t-- > 0)
            p = p.next;
        q = lenA > lenB ? headB : headA;
        while (p != q) {
            p = p.next;
            q = q.next;
        }
        return p;
    }

    private ListNode[] createList(String[] listA, String[] listB, int iNode) {
        ListNode fheadA = new ListNode(-1), fheadB = new ListNode(-1), p = fheadA, ip = null;
        for (String i : listA) {
            int iVal = Integer.parseInt(i);
            ListNode t = new ListNode(iVal);
            p.next = t;
            p = p.next;
            if (iVal == iNode)
                ip = t;
        }
        p = fheadB;
        for (String i : listB) {
            int iVal = Integer.parseInt(i);
            if (iVal != iNode) {
                ListNode t = new ListNode(iVal);
                p.next = t;
                p = p.next;
            } else {
                p.next = ip;
                break;
            }
        }
        return new ListNode[] { fheadA.next, fheadB.next };
    }

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        File f = new File("input.txt");
        Scanner scan = new Scanner(f);
        while (scan.hasNext()) {
            int iNode = scan.nextInt();
            scan.nextLine();
            String[] listA = scan.nextLine().split(",");
            String[] listB = scan.nextLine().split(",");
            ListNode[] heads = s.createList(listA, listB, iNode);
            ListNode r = s.getIntersectionNode(heads[0], heads[1]);
            System.out.println(r != null ? r.val : "null");
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
        next = null;
    }
}
