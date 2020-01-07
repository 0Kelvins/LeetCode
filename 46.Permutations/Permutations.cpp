/**
 * 46. Permutations
 */
#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    void dfs(vector<vector<int>> &r, vector<int> nums, int n, int k) // 形参nums
    {
        if (k == n) // 递归最深层时存储结果
            r.push_back(nums);
        for (int i = k; i <= n; i++)
        {
            if (i > k) // i == k 时不换
                swap(nums[k], nums[i]);
            dfs(r, nums, n, k + 1);
            // if (i > k) // 利用形参nums不改变原始值，省去换回
            //     swap(nums[k], nums[i]); // 实参要换回
        }
    }

    vector<vector<int>> permute(vector<int> &nums)
    {
        vector<vector<int>> r;
        int n = nums.size() - 1;
        dfs(r, nums, n, 0);
        return r;
    }
};

int main()
{
    Solution s;
    vector<int> nums = {1, 2, 3, 4};
    vector<vector<int>> r = s.permute(nums);
    for (int i = 0; i < r.size(); i++)
    {
        for (int j = 0; j < r[i].size(); j++)
            cout << r[i][j] << " ";
        cout << endl;
    }

    return 0;
}