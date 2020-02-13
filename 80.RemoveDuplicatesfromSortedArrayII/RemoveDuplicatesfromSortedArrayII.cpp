/**
 * 80. Remove Duplicates from Sorted Array II
 */
#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    int removeDuplicates(vector<int> &nums)
    {
        int p = 0;
        for (auto n : nums)
        {
            if (p < 2 || n > nums[p - 2]) // 计数可以用位置来代替，相比之下自己写的真是太罗嗦了/(ㄒoㄒ)/~~
                nums[p++] = n;
        }
        return p;
    }
};

int main()
{
    Solution s;
    vector<int> nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
    int len = s.removeDuplicates(nums);
    for (int i = 0; i < len; i++)
        cout << nums[i] << " ";
    return 0;
}