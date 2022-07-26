import java.util.*;

/**
 * 326. Power of Three
 * Easy
 */
public class Solution {

    private Set<Integer> set = new HashSet<>();

    private Solution() {
        int t = 1;
        while (t < Integer.MAX_VALUE / 3) {
            set.add(t);
            t *= 3;
        }
    }

    public boolean isPowerOfThree(int n) {
        if (set.contains(n)) {
            return true;
        }
        return false;
    }

    // 质数才可以用这个方法判断快速幂
    public boolean isPowerOfThree2(int n) {
        return n > 0 && (int)Math.pow(3, 19) % n == 0;
    }
}
