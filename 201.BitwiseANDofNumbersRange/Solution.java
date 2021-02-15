/**
 * 201. Bitwise AND of Numbers Range
 * Medium
 * 求按位与很简单，主要时要注意剪枝
 */
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int x = m, y = n;
        while (true) {  // 上下界在不同2的阶次时结果为0
            if (x == 0) {
                if (x != y)
                    return 0;
                else
                    break;
            }
            x >>= 1;
            y >>= 1;
        }

        int t = n;
        while (n-- > m) {
            t &= n;
        }
        return t;
    }
    
    public static void main(String[] args) {
        int[][] inputs = { { 5, 7 }, { 0, 1 }, { 0, 0 }, { 2, 16 }, { 2, 3 }, { 3, 7 }, { 2, 17 }, { 13, 15 },
                { 200, 255 } };
        Solution s = new Solution();
        for (int[] range : inputs) {
            System.out.println(s.rangeBitwiseAnd(range[0], range[1]));
        }
    }
}