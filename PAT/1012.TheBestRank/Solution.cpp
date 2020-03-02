/**
 * 1012 The Best Rank
 * C++就很快，即便算法没什么优化
 */
#include <iostream>
#include <algorithm>
using namespace std;

typedef struct Stu
{
    int ID, score[4], rank[4];
} Stu;

int course;

int main()
{
    int n, m;
    char table[5] = "ACME";
    cin >> n >> m;
    Stu s[n];
    for (int i = 0; i < n; ++i)
    {
        cin >> s[i].ID >> s[i].score[1] >> s[i].score[2] >> s[i].score[3];
        s[i].score[0] = (s[i].score[1] + s[i].score[2] + s[i].score[3]) / 3;
    }
    for (int i = 0; i < 4; ++i)
    {
        course = i;
        sort(s, s + n, [](Stu a, Stu b) { return a.score[course] > b.score[course]; });
        for (int j = 0; j < n; ++j)
        {
            if (!j)
                s[j].rank[i] = 1;
            else if (s[j].score[i] == s[j - 1].score[i])
                s[j].rank[i] = s[j - 1].rank[i];
            else
                s[j].rank[i] = j + 1;
        }
    }
    int checkID, i, j, best;
    for (i = 0; i < m; ++i)
    {
        cin >> checkID;
        best = 0;
        for (j = 0; j < n; ++j)
        {
            if (s[j].ID == checkID)
            {
                for (int k = 0; k < 4; ++k)
                    if (s[j].rank[k] < s[j].rank[best])
                        best = k;
                cout << s[j].rank[best] << " " << table[best] << endl;
                break;
            }
        }
        if (j == n)
            cout << "N/A" << endl;
    }
}