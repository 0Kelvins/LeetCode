/**
 * 1001 A+B Format
 */
#include <iostream>
#include <string>
using namespace std;

int main()
{
    int a, b;
    bool s;
    string r;
    cin >> a >> b;
    a = a + b;
    s = a < 0 ? true : false;
    r = "";
    a = abs(a);
    if (!a)
        r = "0";
    int n = 0;
    while (a > 0)
    {
        if (n == 3)
        {
            r = "," + r;
            n = 0;
        }
        b = a % 10;
        r = (char)('0' + b) + r;
        a /= 10;
        n++;
    }
    if (s)
        r = "-" + r;
    cout << r << endl;
    return 0;
}