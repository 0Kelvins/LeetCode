/**
 * 50. Pow(x, n)
 * 应灵活运用递推的方法
 * 部分编译器不可以直接做-(INT_MIN)运算，要先转类型（👎）
 * long在32位机器上和int一样位长，long long是64位
 */
class Solution
{
public:
    double myPow(double x, int n)
    {
        if (x == 0)
            return 0;
        if (x == 1 || n == 0)
            return 1;
        double r = 1;
        long long t = n; // n为INT_MIN时绝对值越界int型
        if (n < 0)       // 用unsigned int也行，但是要知道中间运算的真值是不一样的
        {
            t = -t;
            x = 1 / x;
        }
        if (x == 2)
            r = 1 << t;
        else
        {
            while (t) // 暴力会超时，快速幂方法，例：16 = 4 * 4 = (2*2) * (2*2)
            {
                if (t % 2 == 1)
                    r *= x;
                x *= x;
                t >>= 1;
            }
        }
        return r;
    }
};