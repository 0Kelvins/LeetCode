/**
 * 44. Wildcard Matching 
 */
#include <iostream>
#include <string>
using namespace std;

class Solution
{
public:
    bool isMatch(string s, string p)
    {
        int i = 0, j = 0;
        int ss = s.size(), ps = p.size();
        int last_match = -1, star = -1; // '*'匹配的s中最后位置和'*'在p中位置
        while (i < ss)
        {
            if (j < ps && p[j] == '*')
            {
                star = j;
                j++;
                last_match = i;
            }
            else if (j < ps && (s[i] == p[j] || p[j] == '?'))
            {
                i++;
                j++;
            }
            else if (star != -1) // 失配回退到'*'处匹配
            {
                last_match++; // '*'多匹配一个
                i = last_match;
                j = star + 1; // 重新从'*'后匹配
            }
            else
                return false;
        }
        while (j < ps && p[j] == '*')
            j++;
        return j == ps;
    }

    bool isMatch2(string s, string p) // DP
    {
        int m = s.length(), n = p.length();
        bool f[m + 1][n + 1]{0};
        f[0][0] = 1;
        for (int i = 1; i <= n; i++)
            f[0][i] = p[i - 1] == '*' && f[0][i - 1];

        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (p[j - 1] != '*')
                {
                    if (p[j - 1] == '?' || s[i - 1] == p[j - 1])
                        f[i][j] = f[i - 1][j - 1];
                }
                else
                    f[i][j] = f[i][j - 1] || f[i - 1][j];
            }
        }
        return f[m][n];
    }
};

int main()
{
    Solution s;
    string ss[] = {"aa", "aa", "cb", "adceb", "acdcb", "acdcb", "aa"};
    string ps[] = {"a", "*", "?a", "a*b", "a*c?b", "*a*b", "a*"};
    for (int i = 0; i < 6; i++)
        cout << s.isMatch(ss[i], ps[i]) << endl;
    return 0;
}