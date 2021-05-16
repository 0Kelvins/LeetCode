import java.util.Iterator;
import java.util.TreeSet;

/**
 * 421. Maximum XOR of Two Numbers in an Array
 * Medium
 */
public class Solution {

    private Trie root;
    private int HIGH_BIT = 30;

    // 字典树
    public int findMaximumXOR(int[] nums) {
        int n = nums.length;
        root = new Trie();
        int x = 0;
        for (int i = 1; i < n; ++i) {
            // 将 nums[i-1] 放入字典树，此时 nums[0 .. i-1] 都在字典树中
            add(nums[i - 1]);
            // 将 nums[i] 看作 ai，找出最大的 x 更新答案
            x = Math.max(x, check(nums[i]) ^ nums[i]);
        }
        return x;
    }

    private void add(int k) {
        Trie p = root;
        for (int i = HIGH_BIT; i >= 0; i--) {
            int d = k >> i & 1;
            if (d == 0) {
                if (p.left == null) {
                    p.left = new Trie();
                }
                p = p.left;
            } else {
                if (p.right == null) {
                    p.right = new Trie();
                }
                p = p.right;
            }
        }
    }

    private int check(int k) {
        Trie p = root;
        int x = 0;
        for (int i = HIGH_BIT; i >= 0; i--) {
            int d = k >> i & 1;
            if (d == 0) {
                if (p.right != null) {
                    x = x * 2 + 1;
                    p = p.right;
                } else {
                    x = x * 2;
                    p = p.left;
                }
            } else {
                if (p.left != null) {
                    x = x * 2;
                    p = p.left;
                } else {
                    x = x * 2 + 1;
                    p = p.right;
                }
            }
        }
        return x;
    }

    // 排序剪枝
    public int findMaximumXORBySort(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : nums) {
            set.add(i);
        }

        int maxXOR = 0;
        int i = 0;
        for (Iterator<Integer> it = set.descendingIterator(); it.hasNext();) {
            Integer max = it.next();
            int preHighestBit = i, t = max;
            i = 0;
            while (t > 0) {
                i++;
                t >>= 1;
            }
            if (i < preHighestBit) {
                break;
            }
            for (int j : nums) {
                maxXOR = Math.max(maxXOR, max ^ j);
            }
        }
        return maxXOR;
    }

    public static void main(String[] args) {
        int[][] nums = { { 3, 10, 5, 25, 2, 8 }, { 0 }, { 2, 4 }, { 8, 10, 2 },
                { 14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70 }, {4,5,6,} };
        Solution s = new Solution();
        for (int[] ns : nums) {
            System.out.println(s.findMaximumXOR(ns));
        }
    }
}

/**
 * Trie
 */
class Trie {
    Trie left;
    Trie right;
}