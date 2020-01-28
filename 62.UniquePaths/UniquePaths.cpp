/**
 * 62. Unique Paths
 */
#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    // DP
    int uniquePaths(int m, int n)
    {
        if (m == 1 || n == 1)
            return 1;
        vector<int> dp(m, 1);
        for (int i = 1; i < n; i++)
        {
            for (int j = 1; j < m; j++)
                dp[j] += dp[j - 1];
        }
        return dp[m - 1];
    }

    // 排列(r+d)!/(r!*d!)，r,d为向右、下走的步数
    int uniquePaths2(int m, int n)
    {
        if (m == 1 || n == 1)
            return 1;
        if (--n > --m) // m取大的数，减少循环
            swap(m, n);
        long a = 1; // 避免中间结果溢出int
        for (int i = m + 1, j = 1; i <= m + n; i++, j++)
            a = a * i / j;
        return (int)a;
    }
};

int main()
{
    Solution s;
    cout << s.uniquePaths2(7, 3) << endl;
    return 0;
}