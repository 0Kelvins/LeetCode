/**
 * 1002 A+B for Polynomials
 */
#include <iostream>
#include <iomanip>
#include <map>
using namespace std;
int main()
{
    int i = 2, k, n;
    double an;
    map<int, double> m;
    while (i--)
    {
        cin >> k;
        while (k--)
        {
            cin >> n >> an;
            m[n] += an;
        }
    }
    for (auto it = m.begin(); it != m.end();) // 删除系数0的项
    {
        if (it->second < 0.05 && it->second > -0.05)
            m.erase(it++);
        else
            ++it;
    }
    cout << m.size();
    for (auto it = m.rbegin(); it != m.rend(); ++it)
        cout << " " << it->first << " " << fixed << setprecision(1) << it->second;
    return 0;
}