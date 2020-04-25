import java.util.*;

/**
 * 164. Maximum Gap
 * 这题需要明白桶排序的数学原理来实现线性的求解
 */
class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2)
            return 0;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i : nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        int bucketSize = Math.max(1, (max - min) / (nums.length - 1));
        int bucketNum = (max - min) / bucketSize + 1;
        Bucket[] buckets = new Bucket[bucketNum];
        for (int i : nums) {
            int index = (i - min) / bucketSize;
            if (buckets[index] == null)
                buckets[index] = new Bucket();
            buckets[index].maxVal = Math.max(i, buckets[index].maxVal);
            buckets[index].minVal = Math.min(i, buckets[index].minVal);
        }
        int maxGap = 0, preMax = min;
        for (Bucket b : buckets) {
            if (b == null)
                continue;
            maxGap = Math.max(maxGap, b.minVal - preMax);
            preMax = b.maxVal;
        }
        return maxGap;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] inputs = { { 3, 6, 9, 1 }, { 10 } };
        for (int[] nums : inputs) {
            System.out.println(s.maximumGap(nums));
        }
    }
}

class Bucket {
    public int maxVal = Integer.MIN_VALUE;
    public int minVal = Integer.MAX_VALUE;
}