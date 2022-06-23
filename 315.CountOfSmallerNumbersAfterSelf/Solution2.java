import java.util.*;

/**
 * 315. Count of Smaller Numbers After Self
 * Hard
 * Binary Indexed Tree
 * 比归并速度慢
 */
public class Solution2 {
    
    private int[] bitree;
    private int[] bin;
    private int size;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        discretization(nums);
        bitree = new int[size];
        List<Integer> r = new ArrayList<>();
        // System.out.println(map.keySet().toString());
        // System.out.println(map.values().toString());
        for (int i = 1; i <= n; i++) {
            int idx = getIdx(nums[n - i]);
            r.add(0, query(idx - 1));
            update(idx, 1);
        }
        return r;
    }

    private void discretization(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        size = set.size() + 1;
        bin = new int[size];
        int index = 0;
        for (int num : set) {
            bin[index++] = num;
        }
        Arrays.sort(bin);
    }

    private int getIdx(int x) {
        return Arrays.binarySearch(bin, x) + 1; // idx > 0
    }
    
    private int lowbit(int x) {
        return x & (-x);
    }

    private int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += bitree[i];
            i -= lowbit(i);
        }
        return sum;
    }

    private void update(int i, int x) {
        while (i < size) {
            bitree[i] += x;
            i += lowbit(i); // i > 0
        }
    }
    
    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        int[][] nums = { { 5, 2, 6, 1 }, { -1 }, { -1, -1 } };
        for (int[] ns : nums) {
            List<Integer> r = sol.countSmaller(ns);
            System.out.println(r.toString());
        }
    }
}
