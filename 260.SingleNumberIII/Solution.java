import java.util.*;

/**
 * 260. Single Number III
 * Meidum
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        int allXOR = 0;
        for (int i : nums) {
            allXOR ^= i;
        }
        int xor1 = 0, xor2 = 0;
        int lastBit = allXOR & (-allXOR); // 取最右侧位
        for (int i : nums) {
            if ((i & lastBit) == 0) { // 利用全部异或的一位将数据分成两组
                xor1 ^= i;
            } else {
                xor2 ^= i;
            }
        }
        return new int[] { xor1, xor2 };
    }

    public static void main(String[] args) {
        int[][] nums = { { 1, 2, 1, 3, 2, 5 }, { -1, 0 }, { 0, 1 } };
        Solution s = new Solution();
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(s.singleNumber(nums[i])));
        }
    }
}
