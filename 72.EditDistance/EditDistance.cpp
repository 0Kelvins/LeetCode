/**
 * 72. Edit Distance
 * 这题想半天快睡着了也没想起来用DP啊(╯‵□′)╯︵┻━┻
 * 注：要理解DP格子对应操作的关系
 * 当 word1[i - 1] != word2[j - 1], 三种操作对应情况:
 * 1. 用 word2[j - 1] 替换 word1[i - 1] (dp[i][j] = dp[i - 1][j - 1] + 1);
 * 2. 若 word1[0..i - 1) = word2[0..j)，则删除 word1[i - 1] (dp[i][j] = dp[i - 1][j] + 1);
 * 3. 若 word1[0..i) + word2[j - 1] = word2[0..j)，则插入 word2[j - 1] 到 word1[0..i) (dp[i][j] = dp[i][j - 1] + 1).
 * 具体参考：
 * https://leetcode.com/problems/edit-distance/discuss/25846/C%2B%2B-O(n)-space-DP
 */
#include <iostream>
using namespace std;

class Solution
{
public:
    int minDistance(string word1, string word2)
    {
        int n = word1.size(), m = word2.size();
        int dp[n + 1][m + 1];
        for (int i = 0; i <= n; i++) //当词转化为空字符串时，需要的操作数为字符串长度
            dp[i][0] = i;
        for (int i = 0; i <= m; i++)
            dp[0][i] = i;
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                if (word1[i - 1] == word2[j - 1]) // 当两个字符相同时，需要的操作数为没有这两个字符的字符串长度，即dp[i - 1][j - 1]
                    dp[i][j] = dp[i - 1][j - 1];
                else // 见上面注释
                    dp[i][j] = min(dp[i - 1][j - 1], min(dp[i][j - 1], dp[i - 1][j])) + 1;
            }
        }
        return dp[n][m];
    }

    // DP空间优化倒是算熟悉了
    int minDistance2(string word1, string word2)
    {
        int n = word1.size(), m = word2.size(), pre;
        int dp[m + 1];
        for (int i = 0; i <= m; i++)
            dp[i] = i;
        for (int i = 1; i <= n; i++)
        {
            pre = dp[0];
            dp[0] = i;
            for (int j = 1; j <= m; j++)
            {
                int pre_t = dp[j];
                if (word1[i - 1] == word2[j - 1])
                    dp[j] = pre;
                else
                    dp[j] = min(pre, min(dp[j - 1], dp[j])) + 1;
                pre = pre_t;
            }
        }
        return dp[m];
    }
};

int main()
{
    Solution s;
    string words[][2] = {{"horse", "ros"}, {"intention", "execution"}};
    for (int i = 0; i < 2; i++)
        cout << s.minDistance2(words[i][0], words[i][1]) << endl;
    return 0;
}