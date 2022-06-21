import java.util.Arrays;

/**
 * 313. Super Ugly Number
 * Medium
 */
public class Solution {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int i = 1, len = primes.length;
        int[] uglys = new int[n + 1];
        int[] idx = new int[len]; // currnet ugly idx of primes[i]
        int[] min = new int[len]; // min of primes[i]*ugly
        Arrays.fill(min, 1);
        while (i <= n) {
            int minUgly = Arrays.stream(min).min().getAsInt();
            uglys[i++] = minUgly;
            // System.out.print(minUgly + " ");
            for (int j = 0; j < len; j++) {
                if (min[j] == minUgly) {
                    idx[j]++;
                    min[j] = uglys[idx[j]] * primes[j];
                }
            }
        }
        // System.out.println();
        return uglys[n];
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] n = { 12, 1 };
        int[][] primes = { { 2, 7, 13, 19 }, { 2, 3, 5 } };
        for (int i = 0; i < n.length; i++) {
            System.out.println(sol.nthSuperUglyNumber(n[i], primes[i]));
        }
    }
}
