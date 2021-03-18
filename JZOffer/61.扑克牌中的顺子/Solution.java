/**
 * 61. 扑克牌中的顺子
 * Easy
 * 注意各种情况的覆盖，优化剪枝会比较重要
 */
public class Solution {
    public boolean isStraight(int[] nums) {
        int min = 14, max = -1;
        int[] counter = new int[14];
        for(int n : nums) {
            if(counter[n] == 1)
                return false;
            if(n == 0)
                continue;
            counter[n]++;
            min = n < min ? n : min;
            max = n > max ? n : max;
        }
        return max - min < 5;
    }
}
