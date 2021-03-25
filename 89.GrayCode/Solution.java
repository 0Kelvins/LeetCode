import java.util.*;

/**
 * 89. Gray Code
 * Medium
 * 主要是找规律
 */
public class Solution {

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        res.add(1);
        int t = 1;
        for (int i = 1; i < n; i++) {
            t <<= 1;
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(res.get(j) + t);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 1, 3, 4, 5 };
        Solution sol = new Solution();
        for (int n : nums) {
            List<Integer> res = sol.grayCode(n);
            System.out.println(res.toString());
        }
    }
}

// 00 0
// 01 1
// 11 3
// 10 2

// 000 0
// 001 1
// 011 3
// 010 2
// 110 6
// 100 4
// 101 5
// 111 7
