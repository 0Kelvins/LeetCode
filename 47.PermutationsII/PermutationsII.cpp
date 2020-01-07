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
    void dfs(vector<vector<int>> &r, vector<int> nums, int n, int k) // nums 形参
    {
        if (k == n) // 递归最深层时存储结果
        {
            r.push_back(nums);
            return;
        }
        for (int i = k; i <= n; i++)
        {
            if (i != k && nums[k] == nums[i]) // 去重
                continue;
            swap(nums[k], nums[i]);
            dfs(r, nums, n, k + 1);
        } // 不换回，避免for(i++)时重复值被换回，[1,2,2]->[2,1,2]->[2,2,1](不换回)/[2,1,2](换回)
    }

    vector<vector<int>> permuteUnique(vector<int> &nums)
    {
        vector<vector<int>> r;
        sort(nums.begin(), nums.end());
        dfs(r, nums, nums.size() - 1, 0);
        return r;
    }
};

int main()
{
    Solution s;
    vector<int> nums = {-1, 2, 0, -1, 1, 0, 1};
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