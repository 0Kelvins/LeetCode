import java.io.File;
import java.util.*;

/**
 * 173. Binary Search Tree Iterator
 */
public class Solution {

    private TreeNode createTree(String[] nums) {
        if (nums == null)
            return null;
        List<TreeNode> nodes = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            TreeNode t = null;
            if (!"null".equals(nums[i]))
                t = new TreeNode(Integer.parseInt(nums[i]));
            nodes.add(t);
            if (i != 0) {
                TreeNode parent = nodes.get((i - 1) / 2);
                if (parent == null)
                    continue;
                if (i % 2 == 0)
                    parent.right = t;
                else
                    parent.left = t;
            }
        }
        return nodes.get(0);
    }

    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        File f = new File("input.txt");
        Scanner scan = new Scanner(f);
        while (scan.hasNext()) {
            String[] nums = scan.nextLine().split(",");
            TreeNode root = s.createTree(nums);
            BSTIterator iterator = new BSTIterator(root);
            System.out.println(iterator.next()); // return 3
            System.out.println(iterator.next()); // return 7
            System.out.println(iterator.hasNext()); // return true
            System.out.println(iterator.next()); // return 9
            System.out.println(iterator.hasNext()); // return true
            System.out.println(iterator.next()); // return 15
            System.out.println(iterator.hasNext()); // return true
            System.out.println(iterator.next()); // return 20
            System.out.println(iterator.hasNext()); // return false
        }
        scan.close();
    }
}