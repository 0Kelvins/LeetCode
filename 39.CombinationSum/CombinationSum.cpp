/**
 * 39. Combination Sum
 */
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution
{
public:
    // vector引用传递时要加&，与数组不一样
    void combine(vector<int> candidates, vector<vector<int>> &result, vector<int> &r, int k, int target)
    {
        if (!target) // target == 0
        {
            result.push_back(r);
            return;
        }

        for (int i = k; i < candidates.size() && target >= candidates[i]; i++)
        {
            r.push_back(candidates[i]);
            combine(candidates, result, r, i, target - candidates[i]);
            r.pop_back();
        }
    }

    vector<vector<int>> combinationSum(vector<int> candidates, int target)
    {
        vector<vector<int>> result;
        vector<int> r;
        sort(candidates.begin(), candidates.end()); // 题目未说明给出数据升序
        combine(candidates, result, r, 0, target);
        return result;
    }
};

void printResult(vector<vector<int>> r)
{
    for (int i = 0; i < r.size(); i++)
    {
        for (int j = 0; j < r[i].size(); j++)
        {
            cout << r[i][j] << " ";
        }
        cout << endl;
    }
    cout << endl;
}

int main()
{
    Solution s;
    vector<int> candidates1 = {2, 3, 6, 7};
    int target1 = 7;

    printResult(s.combinationSum(candidates1, target1));

    vector<int> candidates2 = {2, 3, 5};
    int target2 = 8;

    printResult(s.combinationSum(candidates2, target2));

    return 1;
}