/**
 * 319. Bulb Switcher
 * Medium
 * 数学题。
 */
public class Solution {

    public int bulbSwitch(int n) {
        // if (n < 2) {
        //     return n;
        // }
        // int light = 1;
        // for (int i = 2; i <= n; i++) {
        //     int f = 0;
        //     for (int j = 2; j <= i; j++) {
        //         if (i % j == 0) {
        //             f++;
        //         }
        //     }
        //     if (f % 2 == 0) {
        //         light++;
        //     }
        // }
        // return light;
        return (int)Math.sqrt(n);
    }

    public static void main(String[] args) {
        int[] nums = { 8, 3, 1, 0 };
        Solution sol = new Solution();
        for (int n : nums) {
            System.out.println(sol.bulbSwitch(n));
        }
    }
}
