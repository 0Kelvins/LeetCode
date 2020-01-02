/**
 * 42. Trapping Rain Water 
 */
#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    int trap1(vector<int> &height) // O(n^2)
    {
        int rain = 0, left = 0, min, t;
        for (int i = 1; i < height.size(); i++)
        {
            if (height[i] > height[i - 1] && height[i - 1] < height[left])
            {
                min = height[left] < height[i] ? height[left] : height[i];
                for (int j = left + 1; j < i; j++)
                {
                    t = min - height[j];
                    t = t > 0 ? t : 0;
                    height[j] += t;
                    rain += t;
                }
            }
            if (height[i] > height[left])
                left = i;
        }
        return rain;
    }

    int trap(vector<int> &height) // O(n)
    {
        int l = 0, h = height.size() - 1;
        int lMax = 0, hMax = 0, rain = 0;
        while (l < h)
        {
            if (height[l] < height[h]) // 用短板去计算容积
            {
                if (height[l] < lMax)
                    rain += lMax - height[l];
                else
                    lMax = height[l];
                l++;
            }
            else
            {
                if (height[h] < hMax)
                    rain += hMax - height[h];
                else
                    hMax = height[h];
                h--;
            }
        }
        return rain;
    }
};

int main()
{
    Solution s;
    vector<int> h = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    cout << s.trap(h) << endl;
    vector<int> h2 = {5, 4, 1, 2};
    cout << s.trap(h2) << endl;
    return 1;
}