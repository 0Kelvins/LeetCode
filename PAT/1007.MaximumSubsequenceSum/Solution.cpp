/**
 * 1007 Maximum Subsequence Sum
 * case5：
 * 3
 * -1 0 -1
 * 当所有数都小于等于0时，有0不能当作所有数都为负处理
 */
#include <iostream>
using namespace std;

int main()
{
    int n;
    cin >> n;
    int nums[n];
    for (int i = 0; i < n; i++)
        cin >> nums[i];

    int f = 0, first = 0, last = n - 1;
    long long sum = 0, max = 0;
    for (int i = 0; i < n; i++)
    {
        if (nums[i] >= 0) // =，5
        {
            if (sum == 0)
                f = i;
            sum += nums[i];
            if (sum > max || max == 0) //max == 0，5
            {
                last = i;
                first = f;
                max = sum;
            }
        }
        else
        {
            sum += nums[i];
            sum = sum < 0 ? 0 : sum;
        }
    }
    cout << max << " " << nums[first] << " " << nums[last];
    return 0;
}