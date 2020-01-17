/**
 * 55. Jump Game
 * 同45题
 */
#include <iostream>
#include <vector>
using namespace std;
class Solution
{
public:
    bool canJump(vector<int> &nums)
    {
        int max_d = 0;
        int t, n = nums.size() - 1;
        if (n == 0)
            return true;
        for (int i = 0; i <= max_d; i++)
        {
            t = i + nums[i];
            if (t > max_d)
            {
                if (t >= n)
                    return true;
                max_d = t;
            }
        }
        return false;
    }
};

int main()
{
    Solution s;
    vector<vector<int>> nums = {{2, 3, 1, 1, 4}, {3, 2, 1, 0, 4}, {0}};
    for (auto &&i : nums)
        cout << s.canJump(i) << endl;
    return 0;
}