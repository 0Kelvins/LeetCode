import java.util.Stack;

public class BSTIterator {
    private Stack<TreeNode> s;
    private TreeNode cur;
    private TreeNode pre;

    public BSTIterator(TreeNode root) {
        s = new Stack<>();
        cur = root;
        while (cur != null) {
            s.push(cur);
            cur = cur.left;
        }
        pre = null;
    }

    /** @return the next smallest number */
    public int next() throws Exception {
        cur = s.pop();
        TreeNode t = cur;
        int r = cur.val;
        if (cur.right != null && pre != cur.right) {
            cur = cur.right;
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
        }
        pre = t;
        return r;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty();
    }
}