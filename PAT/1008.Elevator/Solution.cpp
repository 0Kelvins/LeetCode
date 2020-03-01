/**
 * 1008 Elevator
 * ↑：6s，↓：4s，stop：5s
 */
#include <iostream>
using namespace std;

int main()
{
    int n, f = 0, gofloor, time = 0;
    cin >> n;
    while (n--)
    {
        cin >> gofloor;
        f = gofloor - f;
        time += (f > 0 ? f * 6 : -f * 4);
        time += 5;
        f = gofloor;
    }
    cout << time;
    return 0;
}