/**
 * 63. Unique Paths II
 */
#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    int uniquePathsWithObstacles(vector<vector<int>> &obstacleGrid)
    {
        int n = obstacleGrid.size();
        if (n == 0)
            return 0;
        int m = obstacleGrid[0].size();
        if (m == 0)
            return 0;
        long dp[m + 1]{0, 1}; // 这行是精髓(ง •_•)ง：第-1列初始化可走路径为0，起点初始化为1，long保证整数过程运算不溢出
        for (int i = 0; i < n; i++)
        {
            for (int j = 1; j <= m; j++) // 对所有点（包含起点终点）都做遍历判断是否能走
                dp[j] = obstacleGrid[i][j - 1] == 1 ? 0 : (dp[j] + dp[j - 1]);
        }
        return (int)dp[m];
    }
};

int main()
{
    Solution s;
    vector<vector<vector<int>>> obstacleGrids = {{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}, {{1}}, {{0}, {1}}, {{1}, {0}}, {{1, 0}}};
    for (auto &&i : obstacleGrids)
        cout << s.uniquePathsWithObstacles(i) << endl;
    return 0;
}