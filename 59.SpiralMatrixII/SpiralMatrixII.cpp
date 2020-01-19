/**
 * 59. Spiral Matrix II
 * 用I中的方法
 */
#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    vector<vector<int>> generateMatrix(int n)
    {
        vector<vector<int>> r(n, vector<int>(n));
        int d_step[4][2] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int ns = n; // 横、纵方向当前要走的步数
        int i = 0, j = -1, k = 0, d = 0;
        while (k < n * n)
        {
            for (int m = 0; m < ns; m++)
            {
                i += d_step[d][0];
                j += d_step[d][1];
                r[i][j] = ++k;
            }
            d = (d + 1) % 4;
            ns = d % 2 ? (ns - 1) : ns;
        }
        return r;
    }
};

int main()
{
    Solution s;
    for (int i = 0; i < 5; i++)
    {
        vector<vector<int>> t = s.generateMatrix(i);
        for (auto &&j : t)
        {
            for (auto &&k : j)
                cout << k << " ";
            cout << endl;
        }
        cout << endl;
    }
    return 0;
}