/**
 * 54. Spiral Matrix
 */
#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    vector<int> spiralOrder(vector<vector<int>> &matrix)
    {
        int top = 0, bottom = matrix.size() - 1, left = 0, right = bottom >= 0 ? matrix[0].size() - 1 : -1;
        vector<int> r;
        int i, j;
        while (top <= bottom || left <= right)
        {
            for (j = left; j <= right && top <= bottom; j++)
                r.push_back(matrix[top][j]);
            top++;
            for (i = top; i <= bottom && left <= right; i++)
                r.push_back(matrix[i][right]);
            right--;
            for (j = right; j >= left && top <= bottom; j--)
                r.push_back(matrix[bottom][j]);
            bottom--;
            for (i = bottom; i >= top && left <= right; i--)
                r.push_back(matrix[i][left]);
            left++;
        }
        return r;
    }

    // 根据行列走的步数变化来做
    vector<int> spiralOrder2(vector<vector<int>> &matrix)
    {
        vector<vector<int>> dirs{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 初始化方向对应的行列变化
        vector<int> res;
        int row = matrix.size();
        if (row == 0)
            return res;
        int col = matrix[0].size();
        if (col == 0)
            return res;

        vector<int> nSteps{col, row - 1}; // 横向、纵向当前要走的步数，分别为对应列、行-1数递减

        int iDir = 0;        // index of direction.
        int ir = 0, ic = -1; // initial position
        while (nSteps[iDir % 2])
        {
            for (int i = 0; i < nSteps[iDir % 2]; ++i)
            {
                ir += dirs[iDir][0];
                ic += dirs[iDir][1];
                res.push_back(matrix[ir][ic]);
            }
            nSteps[iDir % 2]--;
            iDir = (iDir + 1) % 4;
        }
        return res;
    }
};

int main()
{
    Solution s;
    vector<vector<int>> m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}}; //{{1, 2, 3}};{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    vector<int> r = s.spiralOrder(m);                                        //{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
    for (auto &&i : r)                                                       //{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        cout << i << " ";
    return 0;
}