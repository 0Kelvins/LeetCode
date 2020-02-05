/**
 * 75. Sort Colors
 * 把0、2分别换到数组两端就完成了三种元素的排序
 */
#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    void sortColors(vector<int> &nums)
    {
        int red = 0, blue = nums.size() - 1; // red:0, white:1, blue:2
        for (int i = 0; i <= blue; i++)      // 注意遍历顺序和交换的影响
        {
            while (nums[i] == 2 && i < blue)
                swap(nums[i], nums[blue--]);
            while (nums[i] == 0 && i > red)
                swap(nums[i], nums[red++]);
        }
    }
};

int main()
{
    Solution s;
    vector<vector<int>> numss = {{2, 0, 2, 1, 1, 0}, {0}, {}, {0, 1, 2}, {2, 1, 0}, {0, 0, 0}};
    for (auto &&i : numss)
    {
        s.sortColors(i);
        for (auto &&j : i)
            cout << j << " ";
        cout << endl;
    }

    return 0;
}