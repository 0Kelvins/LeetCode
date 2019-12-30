/**
 * 40. Combination Sum II
 */
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution
{
public:
    void combine(vector<int> candidates, vector<vector<int>> &result, vector<int> &r, int k, int target)
    {
        if (!target) // target == 0
        {
            result.push_back(r);
            return;
        }

        for (int i = k; i < candidates.size() && target >= candidates[i]; i++)
        {
            if (i > k && candidates[i] == candidates[i - 1]) // 本次递归函数内，循环不以重复数开头
                continue;
            r.push_back(candidates[i]);
            combine(candidates, result, r, i + 1, target - candidates[i]); // i+1一个候选只用一次
            r.pop_back();
        }
    }

    vector<vector<int>> combinationSum2(vector<int> candidates, int target)
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
    vector<int> candidates1 = {10, 1, 2, 7, 6, 1, 5};
    int target1 = 8;

    printResult(s.combinationSum2(candidates1, target1));

    vector<int> candidates2 = {2, 5, 2, 1, 2};
    int target2 = 5;

    printResult(s.combinationSum2(candidates2, target2));

    return 1;
}