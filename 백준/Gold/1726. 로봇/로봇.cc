#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>
#include <tuple>

using namespace std;

int dy[4] = { 0, 0, 1, -1 };
int dx[4] = { 1, -1, 0, 0 };
int N;
int M;

int changeLeft(int D) {
    if (D == 0)
        return 3;
    else if (D == 1)
        return 2;
    else if (D == 2)
        return 0;
    else
        return 1;
}

int changeRight(int D) {
    if (D == 0)
        return 2;
    else if (D == 1)
        return 3;
    else if (D == 2)
        return 1;
    else
        return 0;
}

bool isPossible(int curY, int curX, int curD, int i, vector<vector<int>>& map) {
    int y = curY;
    int x = curX;

    for (int j = 0; j < i; j++) {
        y += dy[curD];
        x += dx[curD];

        if (y < 0 || y >= N || x < 0 || x >= M)
            return false;

        if (map[y][x] == 1)
            return false;
    }

    return true;
}

int BFS(tuple<int, int, int> start, tuple<int, int, int> end, vector<vector<int>>& map, vector<vector<vector<bool>>>& visited) {
    queue<tuple<int, int, int, int>> q;
    q.push(make_tuple(get<0>(start), get<1>(start), get<2>(start), 0));
    visited[get<0>(start)][get<1>(start)][get<2>(start)] = true;

    while (!q.empty()) {
        int curY = get<0>(q.front());
        int curX = get<1>(q.front());
        int curD = get<2>(q.front());
        int cnt = get<3>(q.front());
        q.pop();

        if (curY == get<0>(end) && curX == get<1>(end) && curD == get<2>(end))
            return cnt;

        for (int i = 1; i <= 3; i++) {
            if (isPossible(curY, curX, curD, i, map)) {
                int nextY = curY + dy[curD] * i;
                int nextX = curX + dx[curD] * i;

                if (!visited[nextY][nextX][curD]) {
                    visited[nextY][nextX][curD] = true;
                    q.push(make_tuple(nextY, nextX, curD, cnt + 1));
                }
            }
        }

        int nextD = changeLeft(curD);
        if (!visited[curY][curX][nextD]) {
            visited[curY][curX][nextD] = true;
            q.push(make_tuple(curY, curX, nextD, cnt + 1));
        }

        nextD = changeRight(curD);
        if (!visited[curY][curX][nextD]) {
            visited[curY][curX][nextD] = true;
            q.push(make_tuple(curY, curX, nextD, cnt + 1));
        }
    }

    return -1;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;
    cin >> M;

    vector<vector<int>> map(N, vector<int>(M, 0));
    vector<vector<vector<bool>>> visited(N, vector<vector<bool>>(M, vector<bool>(4, false)));
    for (int i = 0; i < N; i++)
        for (int j = 0; j < M; j++)
            cin >> map[i][j];

    tuple<int, int, int> startidx;
    tuple<int, int, int> endidx;
    int y;
    cin >> y;
    int x;
    cin >> x;
    int d;
    cin >> d;
    startidx = make_tuple(y - 1, x - 1, d - 1);
    cin >> y;
    cin >> x;
    cin >> d;
    endidx = make_tuple(y - 1, x - 1, d - 1);

    cout << BFS(startidx, endidx, map, visited) << "\n";
}
