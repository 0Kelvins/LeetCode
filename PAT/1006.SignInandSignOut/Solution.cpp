/**
 * 1006 Sign In and Sign Out
 */
#include <iostream>
using namespace std;

int compareTime(string a, string b)
{
    for (int i = 0; i < 8; i++)
    {
        if (a[i] - b[i] != 0)
            return a[i] - b[i];
    }
    return 0;
}

int main()
{
    int n;
    cin >> n;
    string unlockID, lockID, unlockTime = "23:59:59", lockTime = "00:00:00";
    string ID, startTime, endTime;
    while (n--)
    {
        cin >> ID >> startTime >> endTime;
        if (compareTime(startTime, unlockTime) < 0)
        {
            unlockTime = startTime;
            unlockID = ID;
        }
        if (compareTime(lockTime, endTime) < 0)
        {
            lockTime = endTime;
            lockID = ID;
        }
    }
    cout << unlockID << " " << lockID;
    return 0;
}