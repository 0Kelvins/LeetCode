/**
 * 77. Combinations
 */
#include <iostream>
#include <vector>
using namespace std;

class Solution
{
private:
    void backtrack(vector<vector<int>> &r, vector<int> &t, int s, int n, int k)
    {
        if (t.size() == k)
        {
            r.push_back(t);
            return;
        }
        for (int i = s; i <= n - (k - t.size()) + 1; i++) // 当数不够时不继续
        {
            t.push_back(i);
            backtrack(r, t, i + 1, n, k);
            t.pop_back();
        }
    }

public:
    vector<vector<int>> combine(int n, int k)
    {
        vector<vector<int>> r;
        vector<int> t;
        backtrack(r, t, 1, n, k);
        return r;
    }

    // 这个解有点厉害，就是不太想得到，应该是用到了字典序
    // https://leetcode.com/problems/combinations/discuss/26992/Short-Iterative-C%2B%2B-Answer-8ms
    vector<vector<int>> combine2(int n, int k)
    {
        vector<vector<int>> result;
        int i = 0;
        vector<int> p(k, 0);
        while (i >= 0)
        {
            p[i]++;
            if (p[i] > n)
                --i;
            else if (i == k - 1)
                result.push_back(p);
            else
            {
                ++i;
                p[i] = p[i - 1];
            }
        }
        return result;
    }
};

int main()
{
    Solution s;
    vector<vector<int>> r = s.combine(4, 2);
    for (auto &&i : r)
    {
        for (auto &&j : i)
            cout << j << " ";
        cout << endl;
    }
    return 0;
}