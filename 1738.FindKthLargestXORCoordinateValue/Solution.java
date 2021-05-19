import java.util.PriorityQueue;

/**
 * 1738. Find Kth Largest XOR Coordinate Value
 * Medium
 */
public class Solution {

    public int kthLargestValue(int[][] matrix, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        int n = matrix.length, m = matrix[0].length;
        int[][] xor = new int[n][m];
        xor[0][0] = matrix[0][0];
        heap.add(xor[0][0]);
        for (int i = 1; i < n; i++) {
            xor[i][0] = xor[i - 1][0] ^ matrix[i][0];
            heap.add(xor[i][0]);
            while (heap.size() > k) {
                heap.remove();
            }
        }
        for (int j = 1; j < m; j++) {
            xor[0][j] = xor[0][j - 1] ^ matrix[0][j];
            heap.add(xor[0][j]);
            while (heap.size() > k) {
                heap.remove();
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                xor[i][j] = xor[i - 1][j] ^ xor[i][j - 1] ^ xor[i - 1][j - 1] ^ matrix[i][j];
                heap.add(xor[i][j]);
                if (heap.size() > k) {
                    heap.remove();
                }
            }
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        int[][] matrix =  { { 5, 2, 4 }, { 1, 6, 3 }, {7, 2, 9} };
        int[] k = { 1, 2, 3, 4 };
        Solution s = new Solution();
        for (int i = 0; i < k.length; i++) {
            System.out.println(s.kthLargestValue(matrix, k[i]));
        }
    }
}