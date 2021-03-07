/**
 * 400. Nth Digit
 * Medium
 * 1~9 9
 * 10~99 90*2
 * 100~999  900*3
 */
public class Solution {

    public int findNthDigit(int n) {
        int i = 0, j = 0;
        long t = 0, numsOfLevel = 0;
        while (n > t) {
            i += numsOfLevel;
            numsOfLevel = 9 * (long)Math.pow(10, j++);  // 注意边界及类型转化
            t += numsOfLevel * j;
        }
        int r = n - (int)(t - numsOfLevel * j);
        i += r / j;
        int mod = r % j;
        if (mod > 0) { // 是否整除
            i++;
            mod--;
        }
        else {
            mod = j - 1;
        }
        String nth = String.valueOf(i).substring(mod, mod + 1);
        return Integer.valueOf(nth);
    }
    
    public static void main(String[] args) {
        int[] nums = { 3, 11, 20, 1000000000 };
        Solution s = new Solution();
        for (int i : nums) {
            System.out.println(s.findNthDigit(i));
        }
    }
}