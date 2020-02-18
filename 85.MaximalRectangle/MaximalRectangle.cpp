/**
 * 85. Maximal Rectangle
 * 主要解法都是利用前一题的解法把矩形分解成柱状图来做
 */
#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    int maximalRectangle(vector<vector<char>> &matrix)
    {
        int n = matrix.size();
        if (!n)
            return 0;
        int m = matrix[0].size();
        if (!m)
            return 0;
        int heights[m]{0};
        int boundaryLeft[m], boundaryRight[m]; // 当前柱子高度的最宽边界
        int cur_left, cur_right, maxRec = 0;
        fill_n(boundaryLeft, m, 0);
        fill_n(boundaryRight, m, m);
        for (int r = 0; r < n; r++) // 按行遍历，将当前行以上作为柱状图，循环内替换成前一题任意解法即可
        {
            cur_left = 0, cur_right = m;
            for (int i = 0; i < m; i++)
                heights[i] = matrix[r][i] == '1' ? (heights[i] + 1) : 0;
            for (int i = 0, j = m - 1; i < m; i++, j--)
            {
                if (matrix[r][i] == '1')
                    boundaryLeft[i] = max(boundaryLeft[i], cur_left);
                else
                {
                    boundaryLeft[i] = 0;
                    cur_left = i + 1;
                }
                if (matrix[r][j] == '1')
                    boundaryRight[j] = min(boundaryRight[j], cur_right);
                else
                {
                    boundaryRight[j] = m;
                    cur_right = j;
                }
            }
            for (int i = 0; i < m; i++)
                maxRec = max(maxRec, (boundaryRight[i] - boundaryLeft[i]) * heights[i]);
        }
        return maxRec;
    }
};

int main()
{
    Solution s;
    vector<vector<char>> matrix = {{'1', '0', '1', '0', '0'},
                                   {'1', '0', '1', '1', '1'},
                                   {'1', '1', '1', '1', '1'},
                                   {'1', '0', '0', '1', '0'}};
    cout << s.maximalRectangle(matrix) << endl;
    return 0;
}