/**
 * 84. Largest Rectangle in Histogram
 * 不使用暴力算法的关键在于找到求当前柱子高度对应矩形的边界
 * 还可以使用单调栈来做
 * 参考：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/084zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-6westb/
 */
#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    // DP O(n)
    int largestRectangleArea(vector<int> &heights)
    {
        int n = heights.size();
        if (n == 0)
            return 0;
        int boundaryLeft[n], boundaryRight[n]; // 当前柱子高度的最宽边界
        boundaryLeft[0] = -1;
        boundaryRight[n - 1] = n;
        int p, q;
        for (int i = 1, j = n - 2; i < n; i++, j = n - 1 - i)
        {
            p = i - 1; // 比当前柱子更高的最左侧柱子的下标
            while (p >= 0 && heights[p] >= heights[i])
                p = boundaryLeft[p];
            boundaryLeft[i] = p;

            q = j + 1; // 比当前柱子更高的最右侧柱子的下标
            while (q < n && heights[q] >= heights[j])
                q = boundaryRight[q];
            boundaryRight[j] = q;
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++)
            maxArea = max(maxArea, heights[i] * (boundaryRight[i] - boundaryLeft[i] - 1));

        return maxArea;
    }

    // 暴力
    int largestRectangleArea0(vector<int> &heights)
    {
        int minheight = 0, maxArea = 0;
        for (int i = 0; i < heights.size(); i++)
        {
            int j = 0;
            if (minheight >= heights[i])
            {
                minheight = heights[i];
                maxArea = max(maxArea, heights[i] * (i + 1));
                continue;
            }
            minheight = heights[i];
            while (j <= i)
            {
                minheight = min(heights[i - j], minheight);
                maxArea = max(maxArea, minheight * (++j));
            }
        }
        return maxArea;
    }
};

int main()
{
    Solution s;
    vector<vector<int>> heights = {{2, 1, 5, 6, 2, 3}, {2, 1, 5, 6, 3, 3}, {2, 2, 5, 6, 2, 3}, {11, 8, 5, 1}, {2, 0, 2}};
    for (auto &&i : heights)
        cout << s.largestRectangleArea(i) << endl;
    vector<int> in;
    int t;
    freopen("input.txt", "r", stdin);
    while (cin >> t)
        in.push_back(t);
    cout << s.largestRectangleArea(in) << endl;
    return 0;
}