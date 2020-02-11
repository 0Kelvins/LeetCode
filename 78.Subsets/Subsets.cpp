/**
 * 78. Subsets
 */
#include <iostream>
#include <vector>
using namespace std;

class Solution
{
private:
    void backtrack(vector<int> &nums, vector<vector<int>> &r, vector<int> t, int n, int k)
    {
        for (int i = k; i < n; i++)
        {
            t.push_back(nums[i]);
            r.push_back(t);
            backtrack(nums, r, t, n, i + 1);
            t.pop_back();
        }
    }

public:
    vector<vector<int>> subsets(vector<int> &nums)
    {
        vector<vector<int>> r;
        int n = nums.size();
        vector<int> t = {};
        r.push_back(t);
        backtrack(nums, r, t, n, 0);
        return r;
    }

    // DP/BFS
    vector<vector<int>> subsets2(vector<int> &nums)
    {
        vector<vector<int>> r;
        r.push_back({});
        for (int i = 0; i < nums.size(); i++)
        {
            int rsize = r.size(); // 记录当前已有的结果数，不使用后面循环里push的结果
            for (int j = 0; j < rsize; j++)
            {
                vector<int> t = r[j];
                t.push_back(nums[i]);
                r.push_back(t);
            }
        }
        return r;
    }
};

int main()
{
    Solution s;
    vector<int> nums = {1, 2, 3, 4};
    vector<vector<int>> r = s.subsets2(nums);
    for (auto &&i : r)
    {
        for (auto &&j : i)
            cout << j << " ";
        cout << endl;
    }
    cout << "count:" << r.size();

    return 0;
}