import java.util.*;

/**
 * 204. Count Primes
 * Easy or Hard
 */
public class Solution {

    public int countPrimes(int n) {
        List<Integer> primes = new ArrayList<Integer>();
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) < n; ++j) {
                isPrime[i * primes.get(j)] = 0;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        return primes.size();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = { 0, 10, 1, 100 };
        for (int n : nums) {
            System.out.println(s.countPrimes(n));
        }
    }
}
