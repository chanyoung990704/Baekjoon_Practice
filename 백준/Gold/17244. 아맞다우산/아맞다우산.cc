#include <algorithm>
#include <iostream>
#include <queue>
#include <vector>
#include <tuple>

using namespace std;

int dy[4] = { 0, 0, -1, 1 };
int dx[4] = { -1, 1, 0, 0 };

int BFS(pair<int, int> startidx, pair<int, int> endidx, vector<vector<char>>& map) {

    queue<tuple<int, int, int>> q;
    vector<vector<bool>> visited(map.size(), vector<bool>(map[0].size(), false));
    q.push(make_tuple(startidx.first, startidx.second, 0));
    visited[startidx.first][startidx.second] = true;

    while (!q.empty()) {

        int curY = get<0>(q.front());   int curX = get<1>(q.front());   int cnt = get<2>(q.front());
        q.pop();

        if (curY == endidx.first && curX == endidx.second)
            return cnt;

        for (int i = 0; i < 4; i++) {
            int nextY = curY + dy[i];   int nextX = curX + dx[i];
            if (nextY < 0 || nextY >= map.size() || nextX < 0 || nextX >= map[0].size())
                continue;

            if (!visited[nextY][nextX] && map[nextY][nextX] != '#') {
                visited[nextY][nextX] = true;
                q.push(make_tuple(nextY, nextX, cnt + 1));
            }
        }

    }

    return -1;

}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M;
    cin >> N >> M; // 가로 길이, 세로 길이

    vector<vector<char>> map(M, vector<char>(N));
    pair<int, int> startidx, endidx;
    vector<pair<int, int>> items;

    for (int i = 0; i < M; i++) {
        string input;
        cin >> input;
        for (int j = 0; j < N; j++) {
            map[i][j] = input[j];
            if (input[j] == 'S')
                startidx = make_pair(i, j);
            if (input[j] == 'E')
                endidx = make_pair(i, j);
            if (input[j] == 'X')
                items.push_back(make_pair(i, j));
        }
    }

    if (items.size() == 0) {
        cout << BFS(startidx, endidx, map) << "\n";
        return 0;
    }

    priority_queue<int, vector<int>, greater<int>> pq;
    do {
        int result = 0;
        result += BFS(startidx, items[0], map);
        // 아이템의 개수가 1개 이상인 경우만
        if (items.size() > 1) {
            for (int i = 0; i < items.size() - 1; i++) {
                result += BFS(items[i], items[i + 1], map);
            }
        }
        result += BFS(items[items.size() - 1], endidx, map);
        pq.push(result);
    } while (next_permutation(items.begin(), items.end()));

    cout << pq.top() << "\n";

}
