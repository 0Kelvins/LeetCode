import java.util.*;
import java.io.*;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * 109. Convert Sorted List to Binary Search Tree
 * 快慢指针时间复杂度是O(nlogn)，转链表到List为O(2n)->O(n)，应该是基数小的用例比较多，效率反而没有前者高
 */
class Solution {
    private TreeNode sortedArrayToBST(List<Integer> nums, int start, int end) {
        if (start > end)
            return null;
        int m = (start + end + 1) / 2;
        TreeNode root = new TreeNode(nums.get(m));
        root.left = sortedArrayToBST(nums, start, m - 1);
        root.right = sortedArrayToBST(nums, m + 1, end);
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return sortedArrayToBST(list, 0, list.size() - 1);
    }

    private TreeNode toBST(ListNode head, ListNode tail) {
        if (head == tail)
            return null;
        ListNode p = head, q = head;
        while (q != tail && q.next != tail) {
            p = p.next;
            q = q.next.next;
        }
        TreeNode t = new TreeNode(p.val);
        t.left = toBST(head, p);
        t.right = toBST(p.next, tail);
        return t;
    }

    public TreeNode sortedListToBST2(ListNode head) {
        if (head == null)
            return null;
        return toBST(head, null);
    }

    private void levelTraversal(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode t = q.poll();
                if (t != null) {
                    System.out.print(t.val + " ");
                    q.offer(t.left);
                    q.offer(t.right);
                } else
                    System.out.print("null ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        File f = new File("input.txt");
        Scanner scan = new Scanner(f);
        while (scan.hasNext()) {
            String[] in = scan.nextLine().split(" ");
            int[] nums = new int[in.length];
            for (int i = 0; i < in.length; i++)
                nums[i] = Integer.parseInt(in[i]);
            ListNode fakehead = new ListNode(-1), p = fakehead;
            for (int i = 0; i < nums.length; i++) {
                p.next = new ListNode(nums[i]);
                p = p.next;
            }
            TreeNode t = s.sortedListToBST2(fakehead.next);
            s.levelTraversal(t);
        }
        scan.close();
    }
}