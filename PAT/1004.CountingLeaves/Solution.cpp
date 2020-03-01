/**
 * 1004 Counting Leaves
 * 层次遍历
 */
#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int main()
{
    int n, m, k;
    cin >> n >> m;
    if (m == 0)
    {
        cout << n;
        return 0;
    }
    vector<vector<string>> hierarchy;
    string id;
    for (int i = 0; i < m; i++)
    {
        cin >> id >> k;
        vector<string> t(k + 1);
        t[0] = id;
        for (int j = 1; j < k + 1; j++)
        {
            cin >> id;
            t[j] = id;
        }
        hierarchy.push_back(t);
    }
    int curNum = 1, nextNum = 0, leafNum = 0, i;
    queue<string> q;
    q.push("01");
    while (!q.empty())
    {
        id = q.front();
        q.pop();
        for (i = 0; i < m; i++)
        {
            if (hierarchy[i][0] == id)
            {
                k = hierarchy[i].size() - 1;
                for (int j = 1; j <= k; j++)
                    q.push(hierarchy[i][j]);
                nextNum += k;
                break;
            }
        }
        if (i == m)
            leafNum++;
        if (--curNum == 0)
        {
            if ("01" == id)
                cout << 0;
            else
                cout << " " << leafNum;
            curNum = nextNum;
            nextNum = leafNum = 0;
        }
    }
    return 0;
}