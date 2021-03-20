/**
 * 66. 构建乘积数组
 * Medium
 * Easy
 */
public class Solution {
    public int[] constructArr(int[] a) {
        if(a == null || a.length == 0) 
            return new int[0];
        int n = a.length, t;
        int[] b = new int[n];
        b[0] = 1;
        for (int i = 1; i < n; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        t = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            b[i] *= t;
            t *= a[i];
        }
        return b;
    }
    
    public static void main(String[] args) {
        int[][] nums = { { 1, 2, 3, 4, 5 }, { 0, 1, 1, 1, 1, 1 } };
        Solution sol = new Solution();
        for (int[] a : nums) {
            int[] b = sol.constructArr(a);
            for (int i : b) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
