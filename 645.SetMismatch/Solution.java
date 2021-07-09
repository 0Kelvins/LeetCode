import java.util.BitSet;

/**
 * 645. Set Mismatch
 * Easy
 */
public class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length, sum = 0, nsum = n * (n + 1) / 2, duplicate = -1;
        BitSet bitSet = new BitSet(n + 1);
        for (int i : nums) {
            sum += i;
            if (bitSet.get(i)) {
                duplicate = i;
            } else {
                bitSet.set(i);
            }
        }
        return new int[] { duplicate, nsum - sum + duplicate };
    }
}
