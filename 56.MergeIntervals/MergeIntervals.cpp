/**
 * 56. Merge Intervals
 */
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
class Solution
{
    // private:
    // 与默认的对二维向量排序结果一致，自己的比较函数要注意是静态的(linux下的编译器报错更准确)
    // static bool cmp(const vector<int> &a, const vector<int> &b)
    // {
    //     return a[0] < b[0];
    // }

public:
    vector<vector<int>> merge(vector<vector<int>> &intervals)
    {
        int n = intervals.size();
        if (n == 0)
            return intervals;

        sort(intervals.begin(), intervals.end());

        vector<vector<int>> r;
        r.push_back(intervals[0]);
        int nr = 0;
        for (int i = 1; i < n; i++) // 这里先填入再修改会更快
        {
            if (intervals[i][0] <= r[nr][1])
            {
                r[nr][1] = max(intervals[i][1], r[nr][1]);
            }
            else
            {
                r.push_back(intervals[i]);
                nr++;
            }
        }

        return r;
    }
};

int main()
{
    Solution s;
    vector<vector<int>> intervals = {{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}}; // {{1, 5}, {2, 3}}; //{{1, 4}, {4, 5}}; //{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    vector<vector<int>> r = s.merge(intervals);
    for (auto &&i : r)
    {
        for (auto &&j : i)
            cout << j << " ";
        cout << endl;
    }

    return 0;
}