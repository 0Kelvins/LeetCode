/**
 * 65. Valid Number
 * 虽然几乎都是👎，但是想试试坑在哪😂（写着写着就发现有好多坑了。然后看了眼讨论区。。。）
 * 理解DFA参考：
 * https://leetcode-cn.com/problems/valid-number/solution/biao-qu-dong-fa-by-user8973/
 * 实现参考：
 * https://leetcode.com/problems/valid-number/discuss/23725/C%2B%2B-My-thought-with-DFA
 */
#include <iostream>
using namespace std;

class Solution
{
public:
    // DFA状态机，复习下这个，不然就不写这题了。
    bool isNumber(string s)
    {
        s.erase(0, s.find_first_not_of(" "));
        s.erase(s.find_last_not_of(" ") + 1);
        int state = 0, f_num = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (s[i] >= '0' && s[i] <= '9')
            {
                f_num = 1;
                if (state <= 2)
                    state = 2;
                else
                    state = (state < 5) ? 4 : 7;
            }
            else if (s[i] == '-' || s[i] == '+')
            {
                if (state == 0 || state == 5)
                    state++;
                else
                    return false;
            }
            else if (s[i] == '.')
            {
                if (state < 3)
                    state = 3;
                else
                    return false;
            }
            else if (s[i] == 'e')
            {
                if (f_num && (state == 2 || state == 3 || state == 4))
                    state = 5;
                else
                    return false;
            }
            else
                return false;
        }
        return (state == 2 || state == 7 || (f_num && state == 3) || state == 4);
    }
};

int main()
{
    Solution s;
    string ss[] = {"0", " 0.1 ", "2e10", " -90e3   ", " 6e-1", "53.5e93", "123", " 123 ", "0", "0123",
                   "00", "-10", "-0", "123.5", "123.000000", "-500.777", "0.0000001", "0.00000", "0.", "00.5",
                   "123e1", "1.23e10", "0.5e-10", "0.5e04", ".1", "2e0", "+.8", " 005047e+6",                                      // “true”
                   " --6 ", "-+3", "95a54e53", "abc", "1 a", " 1e", "e3", " 99e2.5 ", "1.0e4.5", "12 3", "1a3", "", "     ", "."}; // false
    int k = 1;
    for (auto &&i : ss)
    {
        cout << s.isNumber(i);
        if (k++ % 10 == 0)
            cout << endl;
    }

    return 0;
}