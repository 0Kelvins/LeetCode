import java.util.*;

/**
 * 401. Binary Watch
 * Easy
 * 直接遍历判断时间对应位是否位n会更简单
 */
public class Solution {
    int[] bit = { 1, 2, 4, 8, 1, 2, 4, 8, 16, 32 };

    private void getTime(int[] time, int k, int n, List<String> ans) {
        int m = bit.length;
        if (n == 0) {
            int hour = 0;
            for (int i = 0; i < 4; i++) {
                if (time[i] == 1) {
                    hour += bit[i];
                }
            }
            if (hour >= 12) {
                return;
            }
            int miunte = 0;
            for (int i = 4; i < 10; i++) {
                if (time[i] == 1) {
                    miunte += bit[i];
                }
            }
            if (miunte > 59) {
                return;
            }
            String hh = String.valueOf(hour), mm = String.valueOf(miunte);
            if (miunte < 10) {
                mm = "0" + mm;
            }
            ans.add(hh + ":" + mm);
            // System.out.println(Arrays.toString(time));
            return;
        }
        for (int i = k; i <= m - n; i++) {
            time[i] = 1;
            getTime(time, i + 1, n - 1, ans);
            time[i] = 0;
        }
    }

    public List<String> readBinaryWatch(int num) {
        int[] time = new int[10];
        List<String> ans = new ArrayList<>();
        getTime(time, 0, num, ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] turnedOn = { 1, 2, 9 };
        Solution s = new Solution();
        for (int num : turnedOn) {
            List<String> ans = s.readBinaryWatch(num);
            Collections.sort(ans);
            System.out.println(ans.toString());
        }
    }
}