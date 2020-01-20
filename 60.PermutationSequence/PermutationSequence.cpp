/**
 * 60. Permutation Sequence
 */
#include <iostream>
#include <vector>
using namespace std;
class Solution
{
public:
    // 利用k除以n-1个数的排列n!得到当前数的位置
    string getPermutation(int n, int k)
    {
        vector<char> nums = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        string r = "";
        k = k - 1;
        while (n-- > 0)
        {
            int j = 1;
            for (int i = n; i > 1; i--) // 阶乘，有递进关系，可以优化但是会不易读
                j *= i;
            r = r + nums[k / j];
            nums.erase(nums.begin() + k / j);
            k = k % j;
        }
        return r;
    }
};

int main()
{
    Solution s;
    cout << s.getPermutation(3, 3) << endl;
    cout << s.getPermutation(4, 9) << endl;
    return 0;
}