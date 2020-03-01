/**
 * 1003 Emergency
 * 需要统计最短路径数量和最短路径的最大救援队数，使用Dijkstra来解决单源最短路径问题，并统计最短路数量
 */
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

#define INF 0x7fffffff;

int main()
{
    int cities, roads, curCity, savCity;
    cin >> cities >> roads >> curCity >> savCity;
    int teams[cities];
    vector<vector<int>> MGraph(cities, vector<int>(cities, -1));
    for (int i = 0; i < cities; i++)
    {
        cin >> teams[i];
        MGraph[i][i] = 0;
    }
    int c1, c2, l;
    for (int i = 0; i < roads; i++)
    {
        cin >> c1 >> c2 >> l;
        MGraph[c1][c2] = MGraph[c2][c1] = l;
    }

    int s[cities], dist[cities], pathNum[cities], maxTeam[cities];
    for (int i = 0; i < cities; i++) // 初始化
    {
        dist[i] = MGraph[curCity][i];
        maxTeam[i] = MGraph[curCity][i] > 0 ? (teams[i] + teams[curCity]) : teams[i];
        pathNum[i] = 1;
        s[i] = 0;
    }
    s[curCity] = 1;

    for (int i = 1; i < cities; i++) // 双循环
    {
        int minDist = INF;
        for (int j = 0; j < cities; j++) // 将最近的vj加入s集合
        {
            if (!s[j] && dist[j] != -1 && minDist > dist[j])
            {
                minDist = dist[j];
                curCity = j;
            }
        }
        if (curCity == savCity)
            break;
        s[curCity] = 1;
        for (int j = 0; j < cities; j++) // 更新s到剩余顶点的距离
        {
            if (MGraph[curCity][j] != -1 && !s[j])
            {
                if (dist[j] == -1 || dist[j] > dist[curCity] + MGraph[curCity][j]) // 更新更短的路径及对应救援队数
                {
                    dist[j] = dist[curCity] + MGraph[curCity][j];
                    maxTeam[j] = maxTeam[curCity] + teams[j];
                    pathNum[j] = pathNum[curCity]; // 当前点的路径数等于前一个点的路径数
                }
                else if (dist[j] == dist[curCity] + MGraph[curCity][j]) // 更新同距离路径数及最大救援队数
                {
                    maxTeam[j] = max(maxTeam[curCity] + teams[j], maxTeam[j]);
                    pathNum[j] += pathNum[curCity]; // 当前点的路径数加上前一个点的路径数
                }
            }
        }
    }
    cout << pathNum[savCity] << " " << maxTeam[savCity];
    return 0;
}