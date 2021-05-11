import java.util.Arrays;

/**
 * 1734. Decode XORed Permutation
 * Medium
 * 主要是能找到获得排列第一个数的方法
 */
public class Solution {

    public int[] decode(int[] encoded) {
        int n = encoded.length, m = n + 1;
        int allXOR = 0;  // 排列的所有数的异或值
        for (int i = 1; i <= m; i++) {
            allXOR ^= i;
        }
        int oddXOR = 0;  // 排列除了第一个数的异或值
        for (int i = 1; i < encoded.length; i += 2) { // 利用encoded获得
            oddXOR ^= encoded[i];
        }
        int[] perm = new int[m];
        perm[0] = allXOR ^ oddXOR; // 利用前面的结果得到排列的第一个数

        for (int i = 0; i < n; i++) {
            perm[i + 1] = perm[i] ^ encoded[i];
        }

        return perm;
    }

    public static void main(String[] args) {
        int[][] encoded = { { 3, 1 }, { 6, 5, 4, 6 }, { 3, 12, 1, 15, 5, 2, 3, 7 } };
        Solution s = new Solution();
        for (int[] e : encoded) {
            int[] decoded = s.decode(e);
            for (int d : decoded) {
                System.out.print(d + " ");
            }
            System.out.println();
        }
    }
}
