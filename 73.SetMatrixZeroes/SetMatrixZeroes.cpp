/**
 * 73. Set Matrix Zeroes
 * 最小空间复杂度方法：
 * 把行列是否存在0标记到行首、列首，利用对应位置来做标记，第0行和第0列占同一格子，用col0来代替区分
 * 参考：
 * https://leetcode.com/problems/set-matrix-zeroes/discuss/26014/Any-shorter-O(1)-space-solution
 */
#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    void setZeroes(vector<vector<int>> &matrix)
    {
        int n = matrix.size();
        if (n == 0)
            return;
        int m = matrix[0].size();
        int cols[m]{0}, row;
        for (int i = 0; i < n; i++)
        {
            row = 0;
            for (int j = 0; j < m; j++)
            {
                if (matrix[i][j] == 0) // 这里牺牲了时间换空间
                {
                    cols[j] = row = 1;
                    int t1 = i, t2 = j;
                    while (t1--) // 存在重复置0的情况
                        matrix[t1][j] = 0;
                    while (t2--)
                        matrix[i][t2] = 0;
                }
                else if (cols[j] == 1 || row == 1)
                {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    void setZeroes2(vector<vector<int>> &matrix)
    {
        int col0 = 1, rows = matrix.size(), cols = matrix[0].size();

        for (int i = 0; i < rows; i++)
        {
            if (matrix[i][0] == 0) // 第0行和第0列占同一格子，用col0来代替区分
                col0 = 0;
            for (int j = 1; j < cols; j++)
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
        }

        for (int i = rows - 1; i >= 0; i--)
        {
            for (int j = cols - 1; j >= 1; j--)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            if (col0 == 0)
                matrix[i][0] = 0;
        }
    }
};

int main()
{
    Solution s;
    vector<vector<vector<int>>> matrixs = {{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}},
                                           {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}}};
    for (auto &&i : matrixs)
    {
        s.setZeroes(i);
        for (auto &&j : i)
        {
            for (auto &&k : j)
                cout << k << " ";
            cout << endl;
        }
        cout << endl;
    }
    return 0;
}