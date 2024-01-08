#include <algorithm>
#include <iostream>
#include <vector>
#include <tuple>
#include <queue>

using namespace std;

tuple<int, int> dydx[4] = { {0,1},{0,-1},{1,0},{-1,0} };

void bfsMapping(int y, int x, int mapcnt, vector<vector<int>>& map) {
    vector<vector<bool>> visited(100, vector<bool>(100, false));
    visited[y][x] = true;
    map[y][x] = mapcnt;
    queue<tuple<int, int>> q;
    q.push(make_tuple(y, x));

    while (!q.empty()) {
        int curY = get<0>(q.front());	int curX = get<1>(q.front());
        q.pop();

        for (tuple<int, int> n : dydx) {
            int nextY = curY + get<0>(n);	int nextX = curX + get<1>(n);

            if (nextY >= 0 && nextY < map.size() && nextX >= 0 && nextX < map.size()) {
                if (!visited[nextY][nextX] && map[nextY][nextX] == 1) {
                    visited[nextY][nextX] = true;
                    q.push(make_tuple(nextY, nextX));
                    map[nextY][nextX] = mapcnt;
                }
            }
        }
    }
}

int bfs(int y, int x, int mapcnt, vector<vector<int>>& map) {
    vector<vector<bool>> visited(100, vector<bool>(100, false));
    visited[y][x] = true;
    queue<tuple<int, int, int>> q;
    q.push(make_tuple(y, x, 0));

    while (!q.empty()) {
        int curY = get<0>(q.front());	int curX = get<1>(q.front());	int cnt = get<2>(q.front());
        q.pop();

        if (map[curY][curX] != 0 && map[curY][curX] != mapcnt)
            return cnt - 1;

        for (tuple<int, int> n : dydx) {
            int nextY = curY + get<0>(n);	int nextX = curX + get<1>(n);

            if (nextY >= 0 && nextY < map.size() && nextX >= 0 && nextX < map.size()) {
                if (!visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    q.push(make_tuple(nextY, nextX, cnt + 1));
                }
            }
        }
    }
    return -1;
}

int main() {
    int N;	cin >> N;
    vector<vector<int>> map(N, vector<int>(N, 0));

    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            cin >> map[i][j];

    int mapcnt = 2;
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            if (map[i][j] == 1) {
                bfsMapping(i, j, mapcnt, map);
                mapcnt++;
            }

    int answer = 987654321;
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            if (map[i][j] > 1)
                answer = min(answer, bfs(i, j, map[i][j], map));

    cout << answer;
}
