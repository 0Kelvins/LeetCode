import java.util.Arrays;

/**
 * 1310. XOR Queries of a Subarray
 * Medium
 */
public class Solution {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] xors = new int[arr.length + 1];
        xors[0] = 0;
        for (int i = 1; i <= arr.length; i++) {
            xors[i] = xors[i - 1] ^ arr[i - 1];
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = xors[queries[i][0]] ^ xors[queries[i][1] + 1];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 3, 4, 8 }, { 4, 8, 2, 10 }, { 1 } };
        int[][][] queries = { { { 0, 1 }, { 1, 2 }, { 0, 3 }, { 3, 3 } }, 
                { { 2, 3 }, { 1, 3 }, { 0, 0 }, { 0, 3 } }, 
                { { 0, 0 }, { 0, 0 } } };
        Solution s = new Solution();
        for (int i = 0; i < queries.length; i++) {
            int[] ans = s.xorQueries(arr[i], queries[i]);
            System.out.println(Arrays.toString(ans)); 
        }
    }
}