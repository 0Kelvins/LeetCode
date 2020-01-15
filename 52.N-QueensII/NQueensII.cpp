/**
 * 52. N-Queens II
 * 做过前一题就不难了
 */
#include <iostream>
using namespace std;

class Solution
{
private:
    void solve(int &r, int n, int f_col[], int f_lt[], int f_rt[], int row, int col)
    {
        if (row == n)
        {
            r++;
            return;
        }
        for (int j = 0; j < n; j++)
        {
            if (!f_col[j] && !f_lt[n + row - j - 1] && !f_rt[row + j])
            {
                f_col[j] = f_lt[n + row - j - 1] = f_rt[row + j] = 1;
                solve(r, n, f_col, f_lt, f_rt, row + 1, j);
                f_col[j] = f_lt[n + row - j - 1] = f_rt[row + j] = 0;
            }
        }
    }

public:
    int totalNQueens(int n)
    {
        if (n == 0) // 放这里省去后面分配内存，注意1的时候是1
            return 0;
        int r = 0;
        int f_col[n]{0}, f_lt[2 * n - 1]{0}, f_rt[2 * n - 1]{0};
        solve(r, n, f_col, f_lt, f_rt, 0, 0);
        return r;
    }
};

int main()
{
    Solution s;
    for (int i = 0; i < 10; i++) // 0 1 0 0 2 10 4 40 92 352
        cout << s.totalNQueens(i) << endl;
    return 0;
}