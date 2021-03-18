/**
 * 64. 求1+2+…+n
 * Medium
 * 就检查下题目，没有递归，就是考递归，但是发现怎么终止递归才是问题关键 
 * 快速乘法有点意思
 */
public class Solution {
    public int sumNums(int n) {
        boolean t = n > 0 && (n += sumNums(n - 1)) > 0; // 利用&&性质
        return n;
    }

    // 快速乘法
    int quickMulti(int A, int B) {
        int ans = 0;
        for (; B > 0; B >>= 1) {
            if ((B & 1) > 0)
                ans += A;
            A <<= 1;
        }

        // 题目n取[0, 10000]<2^14，故可以重复下面代码14次代替循环
        // flag = ((B & 1) > 0) && (ans += A) > 0;
        // A <<= 1;
        // B >>= 1;
        return ans;
    }

    // n * (n+1) >> 1
    public int sumNums2(int n) {
        return quickMulti(n, n + 1) >> 1;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 5, 1000, 10000 };
        Solution sol = new Solution();
        for (int i : nums) {
            System.out.println(sol.sumNums2(i));
        }
    }
}
