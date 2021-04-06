/**
 * 1006. Clumsy Factorial
 * Medium
 * 还是数学推导的解法更简单。（地铁老人手机
 */
public class Solution {

    public int clumsy(int N) {
        long res = 0;
        boolean flag = false;
        if (N - 3 > 0) {
            res = N * (N - 1) / (N - 2) + (N - 3);
            N -= 4;
            while (N - 3 > 0) {
                res += - N * (N - 1) / (N - 2) + (N - 3);
                N -= 4;
            }
        } else {
            flag = true;
        }
        switch (N) {
            case 1:
                res -= N;
                break;
            case 2:
                res -= N * (N - 1);
                break;
            case 3:
                res -= N * (N - 1) / (N - 2);
                break;
            default:
                break;
        }
        return (int)(flag ? -res : res);
    }

    public static void main(String[] args) {
        int[] nums = { 4, 10, 1, 3, 18, 19, 999 };
        Solution s = new Solution();
        for (int n : nums) {
            System.out.println(s.clumsy(n));
        }
    }
}