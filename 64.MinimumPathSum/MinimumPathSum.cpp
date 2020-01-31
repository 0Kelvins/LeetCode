/**
 * 64. Minimum Path Sum
 */
#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    int minPathSum(vector<vector<int>> &grid)
    {
        int n = grid.size();
        if (n == 0)
            return 0;
        int m = grid[0].size();
        if (m == 0)
            return 0;
        vector<long> dp(m + 1, INT_MAX); // 注意预设的dp值和起点的值就可以了
        dp[1] = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 1; j <= m; j++)
                dp[j] = min(dp[j - 1], dp[j]) + grid[i][j - 1];
        }
        return (int)dp[m];
    }
};

int main()
{
    Solution s;
    vector<vector<int>> grid = {{1, 3, 1},
                                {1, 5, 1},
                                {4, 2, 1}};
    cout << s.minPathSum(grid) << endl;
    return 0;
}