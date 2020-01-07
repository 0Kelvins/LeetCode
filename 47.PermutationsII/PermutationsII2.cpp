/**
 * 47. Permutations II
 */
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution
{
public:
    // 方法1.
    void backtracking(vector<int> &nums, vector<vector<int>> &res, int begin)
    {
        if (begin == nums.size() - 1)
        {
            res.push_back(nums);
            return;
        }
        for (int i = begin; i < nums.size(); i++)
        {
            if ((nums[i] != nums[begin] || i == begin) && checkmiddle(nums, i, begin))
            {
                swap(nums[i], nums[begin]);
                backtracking(nums, res, begin + 1);
                swap(nums[i], nums[begin]); // 恢复交换
            }
        }
    }

    // 恢复交换在去重检查时，需要检查前面所有元素是否重复
    bool checkmiddle(vector<int> &nums, int i, int begin)
    {
        for (int k = begin; k < i; k++)
            if (nums[i] == nums[k])
                return false;
        return true;
    }

    vector<vector<int>> permuteUnique(vector<int> &nums)
    {
        sort(nums.begin(), nums.end());
        vector<vector<int>> res;
        backtracking(nums, res, 0);
        return res;
    }
};

int main()
{
    Solution s;
    vector<int> nums = {1, 2, 1}; //-1, 2, 0, -1, 1, 0, 1
    vector<vector<int>> r = s.permuteUnique(nums);
    freopen("output.txt", "w", stdout);
    for (int i = 0; i < r.size(); i++)
    {
        for (int j = 0; j < r[i].size(); j++)
            cout << r[i][j] << " ";
        cout << endl;
    }

    return 0;
}