/**
 * 76. Minimum Window Substring
 * 这题还是很难的，虽然看提示也可以写出来个类滑动窗口的，但是TLE了，不记得ASCII表大小这个窗口就不太好写。
 */
#include <iostream>
using namespace std;

class Solution
{
public:
    string minWindow(string s, string t)
    {
        int l = 0, r = 0, start = 0, len = INT_MAX, counter = t.size();
        int ascii_map[128]{0}; // 用ASCII表大小的字符映射表来计数
        for (auto &&i : t)
            ascii_map[i]++;
        while (r < s.size())
        {
            if (ascii_map[s[r++]]-- > 0) // 这里会对所有s中映射字符操作做--
                counter--;               // 映射字符对应个数和counter配合作为窗口
            while (counter == 0)         // 窗口满操作
            {
                if (r - l < len)
                {
                    start = l;
                    len = r - l;
                }
                if (ascii_map[s[l++]]++ == 0) // 释放窗口条件
                    counter++;
            }
        }
        return len == INT_MAX ? "" : s.substr(start, len);
    }
};

int main()
{
    Solution s;
    cout << s.minWindow("ADOBECODEBANC", "ABC") << endl;
    cout << s.minWindow("ADOBEODEBAN", "ABC") << endl;
    cout << s.minWindow("", "ABC") << endl;
    cout << s.minWindow("A", "AA") << endl;
    cout << s.minWindow("ABB", "AAB") << endl;
    cout << s.minWindow("S", "") << endl;
    string ss, t;
    freopen("input.txt", "r", stdin);
    while (cin >> ss >> t)
        cout << (s.minWindow(ss, t) == ss) << endl;
    return 0;
}
