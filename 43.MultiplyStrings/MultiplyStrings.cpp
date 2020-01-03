/**
 * 43. Multiply Strings
 */
#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    string multiply(string num1, string num2)
    {
        int l1 = num1.length(), l2 = num2.length();
        string result = "";
        int i, s = 0, t1, t2, m;

        if ("0" == num1 || "0" == num2)
            return "0";

        short r[221]{0};
        while (l1-- > 0)
        {
            i = s++;
            t1 = num1[l1] - '0';
            if (!t1)
                continue;
            l2 = num2.length();
            while (l2-- > 0)
            {
                t2 = num2[l2] - '0';
                m = t1 * t2 + r[i];
                r[i] = m % 10;
                if (m >= 10)
                    r[i + 1] += m / 10;
                i++;
            }
        }
        if (m < 10)
            i--;
        for (; i >= 0; i--)
            result += '0' + r[i];

        return result;
    }

    string multiply2(string num1, string num2)
    {
        int m = num1.size(), n = num2.size();
        string ans(m + n, '0');
        for (int i = m - 1; i >= 0; i--)
        {
            for (int j = n - 1; j >= 0; j--) // 主要是乘数的下标与结果下标对应的关系
            {
                int sum = (num1[i] - '0') * (num2[j] - '0') + (ans[i + j + 1] - '0');
                ans[i + j + 1] = sum % 10 + '0';
                ans[i + j] += sum / 10;
            }
        }
        for (int i = 0; i < m + n; i++)
            if (ans[i] != '0')
                return ans.substr(i);

        return "0";
    }
};

int main()
{
    Solution s;
    string num1, num2;
    cout << s.multiply("2", "3") << endl;
    cout << s.multiply("123", "456") << endl;
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    while (cin >> num1 >> num2)
        cout << s.multiply(num1, num2) << endl;
    return 0;
}