#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>
#include <tuple>

using namespace std;

int dy[4] = { 0, 0, 1, -1 };
int dx[4] = { -1, 1, 0, 0 };

int bfs(vector<vector<int>>& maps, vector<vector<bool>>& visited, int n, int m) {
    queue<tuple<int, int, int>> q; // 튜플에 거리 정보 추가
    visited[0][0] = true;
    q.push(make_tuple(0, 0, 1)); // 시작점과 거리 1로 초기화

    while (!q.empty()) {
        int curY = get<0>(q.front());
        int curX = get<1>(q.front());
        int dist = get<2>(q.front());
        q.pop();

        if (curY == n - 1 && curX == m - 1) // 목적지 도착 시 거리 반환
            return dist;

        for (int i = 0; i < 4; i++) {
            int nextY = curY + dy[i];
            int nextX = curX + dx[i];

            if (nextY >= 0 && nextY < n && nextX >= 0 && nextX < m
                && !visited[nextY][nextX] && maps[nextY][nextX] == 1) {
                visited[nextY][nextX] = true;
                q.push(make_tuple(nextY, nextX, dist + 1)); // 거리 정보 업데이트
            }
        }
    }

    return -1; // 목적지에 도달할 수 없는 경우 -1 반환
}

int solution(vector<vector<int> > maps)
{
    int answer = 0;
    int n = maps.size();
    int m = maps[0].size();
    vector<vector<bool>> visited(n, vector<bool>(m, false));
    answer = bfs(maps, visited, n, m);
    return answer;
}