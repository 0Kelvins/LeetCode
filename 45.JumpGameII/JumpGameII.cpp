/**
 * 45. Jump Game II
 */
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution
{
public:
    // 贪心：确定当前位置能到达的最大位置
    int jump(vector<int> &nums)
    {
        int jumps = 0, end = 0, max_pos = 0;
        for (int i = 0; i < nums.size() - 1; i++) // nums.size() - 1：最后一格不用再算
        {
            max_pos = max(max_pos, i + nums[i]);
            if (i == end) // 每次到达end边界jumps++
            {
                end = max_pos;
                jumps++;
            }
        }
        return jumps;
    }
};

int main()
{
    Solution s;
    vector<vector<int>> nums = {{2, 3, 1, 1, 4}, {0}, {1, 1, 3, 1, 1, 1}, {2, 0, 1, 0}, {5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6, 9, 4, 1, 6, 8, 8, 4, 4, 2, 0, 3, 8, 5}};
    for (auto &&i : nums)
        cout << s.jump(i) << endl;
    return 0;
}