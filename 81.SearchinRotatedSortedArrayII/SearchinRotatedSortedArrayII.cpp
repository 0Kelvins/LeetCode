/**
 * 81. Search in Rotated Sorted Array II
 * 这题重复值对条件比较影响很大，并不好处理
 */
#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    bool search(vector<int> &nums, int target)
    {
        int n = nums.size();
        if (n == 0)
            return false;
        int l = 0, h = n - 1, m;
        while (l <= h)
        {
            m = (l + h + 1) / 2;
            if (nums[m] == target)
                return true;
            if (nums[m] == nums[l] && nums[m] == nums[h]) // 当重复值循环在数组两侧时，直接比较处理会很麻烦
            {
                l++;
                h--;
            }
            else if (nums[m] > nums[h])
            {
                if (nums[l] <= target && target < nums[m])
                    h = m - 1;
                else
                    l = m + 1;
            }
            else
            {
                if (nums[m] < target && target <= nums[h])
                    l = m + 1;
                else
                    h = m - 1;
            }
        }
        return false;
    }
};

int main()
{
    Solution s;
    vector<int> nums = {2, 5, 6, 0, 0, 1, 2};
    cout << s.search(nums, 0) << endl;
    cout << s.search(nums, 3) << endl;
    vector<int> nums2 = {0, 0, 1, 2};
    cout << s.search(nums2, 0) << endl;
    cout << s.search(nums2, 3) << endl;
    vector<int> nums3 = {1, 2, 1};
    cout << s.search(nums3, 2) << endl;
    cout << s.search(nums3, 3) << endl;
    vector<int> nums4 = {1, 1, 1, 3, 1};
    cout << s.search(nums4, 3) << endl;
    cout << s.search(nums4, 2) << endl;
    vector<int> nums5 = {3, 1};
    cout << s.search(nums5, 3) << endl;
    cout << s.search(nums5, 2) << endl;
    vector<int> nums6 = {1, 3, 5};
    cout << s.search(nums6, 0) << endl;
    cout << s.search(nums6, 6) << endl;
    return 0;
}