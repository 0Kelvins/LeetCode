/**
 * 46. Permutations
 */
#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    void arrange(vector<vector<int>> &r, vector<int> &nums, int n, int k)
    {
        if (k == n) // 递归最深层时存储结果
            r.push_back(nums);
        for (int i = k; i <= n; i++)
        {
            if (i > k) // i == k 时不换
                swap(nums[k], nums[i]);
            arrange(r, nums, n, k + 1);
            if (i > k)
                swap(nums[k], nums[i]); // 复位
        }
    }

    vector<vector<int>> permute(vector<int> &nums)
    {
        vector<vector<int>> r;
        int n = nums.size() - 1;
        arrange(r, nums, n, 0);
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