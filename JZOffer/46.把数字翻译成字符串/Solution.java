/**
 * 剑指 Offer 46. 把数字翻译成字符串
 * Medium
 * 动态规划，转移的状态分析还是要多练练
 */
public class Solution {
    public int translateNum(int num) {
        int pre1 = 1, pre2 = 1, cur = 1;
        String str = String.valueOf(num);
        for(int i = 1; i < str.length(); i++) {
            int t = Integer.valueOf(str.substring(i-1, i+1));
            if(t >= 10 && t < 26)
                cur = pre1 + pre2;
            else
                cur = pre1;
            pre2 = pre1;
            pre1 = cur;
        }
        return cur;
    }
}