/**
 * 307. Range Sum Query - Mutable
 * Meidum
 * 树状数组or线段树
 * 两种算法都是利用数组存储树结构，对数据进行分块汇总效果
 */
class NumArray {

    private int[] tree;
    private int[] nums;
    private int n = 0;

    public NumArray(int[] nums) {
        this.nums = nums;
        n = nums.length;
        tree = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            add(i, nums[i-1]);
        }
    }
    
    public void update(int index, int val) {
        int t = val - nums[index];
        add(index + 1, t);
        nums[index] = val;
    }
    
    public int sumRange(int left, int right) {
        return queryPrefixSum(right + 1) - queryPrefixSum(left);
    }

    private int lowBit(int x) {
        return x & -x; // ==> n & (~n + 1) , computer save as Compelement Code!
    }
    
    private void add(int i, int val) {
        while (i < tree.length) {
            tree[i] += val;
            i += lowBit(i);
        }
    }

    private int queryPrefixSum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= lowBit(i);
        }
        return sum;
    }
}

public class Solution {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 5 };
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2)); // return 1 + 3 + 5 = 9
        numArray.update(1, 2);   // nums = [1, 2, 5]
        System.out.println(numArray.sumRange(0, 2)); // return 1 + 2 + 5 = 8
    }
}
