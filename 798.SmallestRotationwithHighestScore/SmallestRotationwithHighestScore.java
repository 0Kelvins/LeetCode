/**
 * 798. Smallest Rotation with Highest Score
 * 1. 对A[i]开始不加分的下标统计，每个减1，统计结果越小，越不适合做转换点（K=i的得分统计）
 * 2. 对统计结果向后叠加，取叠加后最大值，即最合适转换点（相对K=0的得分统计）
*/
class Solution {
    public int bestRotation(int[] A) {
        int n = A.length;
        int[] change = new int[n];
        for (int i = 0; i < n; i++)
            change[(i - A[i] + 1 + n) % n]--;
        int maxI = 0;
        for (int i = 1; i < n; i++) {
            change[i] += change[i - 1] + 1;
            maxI = change[i] > change[maxI] ? i : maxI;
        }
		return maxI;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {2, 3, 1, 4, 0},
              b = {1, 3, 0, 2, 4};
        System.out.println(s.bestRotation(a));
        System.out.println(s.bestRotation(b));
    }
}