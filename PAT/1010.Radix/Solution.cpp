/**
 * 1010 Radix
 * 这题太过恶心
 */
#include <iostream>
using namespace std;

#define MAX 0xfffffffffffffff // 必须够大，不然第10个测试点过不去

long long getDecimal(string n, long long radix)
{
    double num = 0, p = 1; // double类型来解决溢出处理的问题
    long long t;
    int nsize = n.length();
    for (int i = nsize - 1; i >= 0; i--)
    {
        if (n[i] >= '0' && n[i] <= '9')
            t = n[i] - '0';
        else if (n[i] >= 'a' && n[i] <= 'z')
            t = n[i] - 'a' + 10;
        else // vscode的内置终端输入的时候不知道怎么空格会变乱码
            continue;
        num += t * p;
        p = p * radix;
    }
    return num > MAX ? MAX : (long long)num;
}

int main()
{
    string n[2];
    long long num[2], radix;
    int tag;
    cin >> n[0] >> n[1] >> tag >> radix;
    tag--;
    num[tag] = getDecimal(n[tag], radix);
    int rtag = (int)!tag, minRadix = 2, t, nlen = n[rtag].size();
    for (int i = 0; i < nlen; i++)
    {
        if (n[rtag][i] >= '0' && n[rtag][i] <= '9')
            t = n[rtag][i] - '0' + 1;
        else if (n[rtag][i] >= 'a' && n[rtag][i] <= 'z')
            t = n[rtag][i] - 'a' + 11;
        else
            continue;
        if (t > minRadix)
            minRadix = t;
    }
    long long left = minRadix, right = MAX, mid, minMid = MAX;
    while (left <= right) // 幂次没有上限，要二分查找，不然超时
    {
        mid = (left + right) / 2;
        num[rtag] = getDecimal(n[rtag], mid);
        if (num[tag] == num[rtag])
        {
            if (mid < minMid)
                minMid = mid;
            right = mid - 1;
        }
        else if (num[rtag] < num[tag])
            left = mid + 1;
        else
            right = mid - 1;
    }
    if (minMid == MAX)
        cout << "Impossible";
    else
        cout << minMid;
    return 0;
}