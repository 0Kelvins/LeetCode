/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * Medium
 * 空序列算对。
 * 用的递归分治，可以精简很多，在最差情况搜索树退化为链表时时间复杂度到O(n^2)
 * 辅助单调栈的方法要巧妙很多
 */
public class Solution {

    private boolean verify(int[] postorder, int preMid, Boolean leftSub, int begin, int end) {
        if (begin >= end)
            return true;
        int mid = postorder[end], i = end - 1;
        while (i >= begin && postorder[i] > mid) {
            if (leftSub && postorder[i] > preMid || !leftSub && postorder[i] < preMid)
                return false;
            i--;
        }
        boolean verifyRight = verify(postorder, mid, false, i + 1, end - 1);
        if(!verifyRight) return false;
        while (i >= begin && postorder[i] > mid) {
            if (leftSub && postorder[i] > preMid || !leftSub && postorder[i] < preMid)
                return false;
            i--;
        }
        return verify(postorder, mid, true, begin, i);
    }

    public boolean verifyPostorder(int[] postorder) {
        int i = postorder.length - 1;
        if (i < 0)
            return true;
        int mid = postorder[i--];
        while (i >= 0 && postorder[i] > mid) {
            i--;
        }
        return verify(postorder, mid, true, 0, i) 
            && verify(postorder, mid, false, i + 1, postorder.length - 2);
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] in = { { 1, 6, 3, 2, 5 }, { 1, 2, 5, 10, 6, 9, 4, 3 }, { 1, 3, 2, 6, 5 } };
        for (int[] i : in) {
            System.out.println(s.verifyPostorder(i));
        }
    }
}