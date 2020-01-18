/**
 * 57. Insert Interval
 */
#include <iostream>
#include <vector>
using namespace std;
class Solution
{
public:
    vector<vector<int>> insert(vector<vector<int>> &intervals, vector<int> &newInterval)
    {
        vector<vector<int>> r;
        int i = 0, n = intervals.size();
        while (i < n && intervals[i][1] < newInterval[0])
            r.push_back(intervals[i++]);

        while (i < n && intervals[i][0] <= newInterval[1])
        {
            newInterval[0] = min(intervals[i][0], newInterval[0]);
            newInterval[1] = max(intervals[i][1], newInterval[1]);
            i++;
        }
        r.push_back(newInterval);

        while (i < n)
            r.push_back(intervals[i++]);

        return r;
    }

    vector<vector<int>> insert1(vector<vector<int>> &intervals, vector<int> &newInterval)
    {
        vector<vector<int>> r;
        int n = intervals.size();
        int m = newInterval.size();
        bool insert_f = false;
        int i = 0;
        if (m == 0)
            return intervals;
        else if (n == 0 || newInterval[0] < intervals[0][0])
        {
            r.push_back(newInterval);
            insert_f = true;
        }
        else
        {
            r.push_back(intervals[0]);
            i++;
        }

        while (i < n || !insert_f) // 思维局限在前一题的解题方法了
        {
            if (!insert_f)
            {
                if (newInterval[0] <= r.back()[1])
                {
                    r.back()[1] = max(newInterval[1], r.back()[1]);
                    insert_f = true;
                }
                else if (i >= n || newInterval[0] < intervals[i][0])
                {
                    r.push_back(newInterval);
                    insert_f = true;
                }
                //else newInterval[0] > intervals[i][0]
            }
            if (i < n)
            {
                if (intervals[i][0] <= r.back()[1])
                    r.back()[1] = max(intervals[i][1], r.back()[1]);
                else
                    r.push_back(intervals[i]);
                i++;
            }
        }

        return r;
    }
};

int main()
{
    Solution s;
    vector<vector<vector<int>>> intervalss = {{{1, 5}}, {{1, 3}, {6, 9}}, {{1, 5}}, {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}};
    vector<vector<int>> newInterval = {{0, 6}, {2, 5}, {2, 7}, {4, 8}};
    for (int i = 0; i < intervalss.size(); i++)
    {
        vector<vector<int>> r = s.insert(intervalss[i], newInterval[i]);
        for (int i = 0; i < r.size(); i++)
        {
            for (int j = 0; j < r[i].size(); j++)
                cout << r[i][j] << " ";
            cout << endl;
        }
        cout << endl;
    }

    return 0;
}