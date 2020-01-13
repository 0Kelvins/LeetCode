#include <iostream> // <>先查找系统路径
using namespace std;
#include "Pow.cpp" // ""会先查找当前目录

int main()
{
    Solution s;
    cout << s.myPow(2.00000, 10) << endl;
    cout << s.myPow(2.10000, 3) << endl;
    cout << s.myPow(2.00000, -2) << endl;
    cout << s.myPow(0.00001, 2147483647) << endl;
    cout << s.myPow(2.00000, -2147483648) << endl;
    return 0;
}