/**
 * 51. N-Queens
 * 利用列、斜线行列和、反斜线行列值，使用辅助标记数组会更快
 */
#include <iostream>
#include <vector>
using namespace std;

class Solution
{
private:
    void solve(int n, vector<vector<string>> &r, vector<string> board, int row, int col)
    {
        if (row != 0) // 对确定的queen对应行、列、斜线进行标记
        {
            int t = row - 1;
            for (int i = 0; i < n; i++)
            {
                if (board[t][i] != 'Q')
                    board[t][i] = '.';
            }
            if (row == n) // 能完成最后一行标记的则为一个解
            {
                r.push_back(board);
                return;
            }
            int k;
            for (int m = 1; m < n - t; m++)
            {
                k = t + m;
                if (board[k][col] != 'Q')
                    board[k][col] = '.';
                if (col - m >= 0)
                    board[k][col - m] = '.';
                if (col + m < n)
                    board[k][col + m] = '.';
            }
        }
        for (int j = 0; j < n; j++) // 逐行尝试
        {
            if (board[row][j] != '.')
            {
                board[row][j] = 'Q';
                solve(n, r, board, row + 1, j);
                board[row][j] = '.';
            }
        }
    }

public:
    vector<vector<string>> solveNQueens(int n)
    {
        vector<vector<string>> r;
        vector<string> board(n, string(n, ' '));
        solve(n, r, board, 0, 0);
        return r;
    }
};

int main()
{
    Solution s;
    vector<vector<string>> r = s.solveNQueens(4);

    for (int i = 0; i < r.size(); i++)
    {
        for (int j = 0; j < r[i].size(); j++)
            cout << r[i][j] << endl;
        cout << endl;
    }

    return 0;
}