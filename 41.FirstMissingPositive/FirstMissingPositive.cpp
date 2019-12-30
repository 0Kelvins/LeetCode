/**
 * 41. First Missing Positive
 * 缺少的正数必小于输入数据数量n
 */
#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    int firstMissingPositive(vector<int> &nums)
    {
        int t, n = nums.size();
        for (int i = 0; i < n; i++)
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) // 交换n以内数到对应位置
            {
                t = nums[i];
                nums[i] = nums[t - 1];
                nums[t - 1] = t;
            }

        for (int i = 0; i < n; i++)
            if (nums[i] != i + 1)
                return i + 1;

        return n + 1;
    }
};

int main()
{
    Solution s;
    vector<int> nums1 = {1, 2, 0};
    vector<int> nums2 = {3, 4, -1, 1};
    vector<int> nums3 = {7, 8, 9, 11, 12};

    cout << s.firstMissingPositive(nums1) << endl;
    cout << s.firstMissingPositive(nums2) << endl;
    cout << s.firstMissingPositive(nums3) << endl;

    return 1;
}