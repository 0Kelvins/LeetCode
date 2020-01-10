/**
 * 49. Group Anagrams
 */
#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>
using namespace std;

class Solution
{
public:
    vector<vector<string>> groupAnagrams(vector<string> &strs)
    {
        vector<vector<string>> r;
        unordered_map<string, vector<string>> m; // 分组的有序字符串做key的map
        for (int i = 0; i < strs.size(); i++)
        {
            string t = strs[i];
            sort(t.begin(), t.end());
            m[t].push_back(strs[i]);
        }
        for (auto i : m)
            r.push_back(i.second);
        return r;
    }

    // 输入都是小写，自己实现排序字符串更快
    vector<vector<string>> groupAnagrams2(vector<string> &strs)
    {
        unordered_map<string, vector<string>> mp;
        vector<vector<string>> anagrams;
        for (string s : strs)
            mp[strSort(s)].push_back(s);
        for (auto p : mp)
            anagrams.push_back(p.second);
        return anagrams;
    }

private:
    string strSort(string s)
    {
        int counter[26] = {0};
        string t;
        for (char c : s)
            counter[c - 'a']++;

        for (int c = 0; c < 26; c++)
            t += string(counter[c], c + 'a');

        return t;
    }
};

int main()
{
    Solution s;
    vector<string> strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    vector<vector<string>> r = s.groupAnagrams(strs);
    for (auto &&i : r)
    {
        for (auto &&j : i)
            cout << j << " ";
        cout << endl;
    }

    return 0;
}