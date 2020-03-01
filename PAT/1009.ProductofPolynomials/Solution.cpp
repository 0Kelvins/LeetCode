/**
 * 1009 Product of Polynomials
 */
#include <iostream>
#include <map>
#include <iomanip>
using namespace std;

int main()
{
    int k[2];
    int exp;
    double co;
    map<int, double> p[2];
    for (int i = 0; i < 2; i++)
    {
        cin >> k[i];
        for (int j = 0; j < k[i]; j++)
        {
            cin >> exp >> co;
            p[i][exp] = co;
        }
    }
    map<int, double> pr;
    for (auto &&i : p[0])
    {
        for (auto &&j : p[1])
        {
            exp = i.first + j.first;
            co = i.second * j.second;
            pr[exp] += co;
        }
    }
    for (auto i = pr.begin(); i != pr.end();)
    {
        if (i->second > -0.05 && i->second < 0.05)
            pr.erase(i++);
        else
            ++i;
    }
    cout << pr.size();
    for (auto i = pr.rbegin(); i != pr.rend(); ++i)
        cout << " " << i->first << " " << fixed << setprecision(1) << i->second;
    return 0;
}