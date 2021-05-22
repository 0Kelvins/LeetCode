/**
 * 1864. Minimum Number of Swaps to Make the Binary String Alternating
 * Medium
 * DFS暴力超时
 */
public class Solution {

    public int minSwaps(String s) {
        char[] sc = s.toCharArray();
        int zero = 0, one = 0; // 0\1的个数
        int oneZeroDiff = 0, zeroOneDiff = 0; // 与1010..的差别位数，与0101..的差别位数
        for (int i = 0; i < sc.length; i++) {
            if ((i & 1) == 0) { // 奇数位
                if (sc[i] == '1') {
                    zeroOneDiff++; // 记录与结果串不同的位数
                    one++;
                } else {
                    oneZeroDiff++;
                    zero++;
                }
            } else {
                if (sc[i] == '1') {
                    oneZeroDiff++;
                    one++;
                } else {
                    zeroOneDiff++;
                    zero++;
                }
            }
        }
        if ((sc.length & 1) == 0) {
            if (zero != one) {
                return -1;
            } else {
                return Math.min(oneZeroDiff, zeroOneDiff) / 2;
            }
        } else {
            int t = sc.length / 2;
            if (t == zero && one == t + 1) {
                return oneZeroDiff / 2; // 最小交换次数为差别的一半
            } else if (t == one && zero == t + 1) {
                return zeroOneDiff / 2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] strs = {"111000","010","1110","0110", "10001", "100101"};
        Solution sol = new Solution();
        for (String s : strs) {
            System.out.println(sol.minSwaps(s));
        }
    }
}
