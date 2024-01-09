#include <iostream>
#include <queue>
#include <cstring>
using namespace std;

char map[12][6];
bool visited[12][6];
int dx[4] = {0, 0, -1, 1};
int dy[4] = {-1, 1, 0, 0};

bool bfs(int y, int x, char color) {
    int connected = 0;
    queue<pair<int, int>> q, boom;
    q.push({y, x});
    boom.push({y, x});
    visited[y][x] = true;

    while (!q.empty()) {
        int curY = q.front().first;
        int curX = q.front().second;
        q.pop();
        connected++;

        for (int i = 0; i < 4; i++) {
            int nextY = curY + dy[i];
            int nextX = curX + dx[i];

            if (nextY >= 0 && nextY < 12 && nextX >= 0 && nextX < 6) {
                if (map[nextY][nextX] == color && !visited[nextY][nextX]) {
                    q.push({nextY, nextX});
                    boom.push({nextY, nextX});
                    visited[nextY][nextX] = true;
                }
            }
        }
    }

    if (connected >= 4) {
        while (!boom.empty()) {
            map[boom.front().first][boom.front().second] = '.';
            boom.pop();
        }
        return true;
    } else {
        return false;
    }
}

bool popPuyo() {
    bool isPopped = false;
    memset(visited, false, sizeof(visited));

    for (int i = 0; i < 12; i++) {
        for (int j = 0; j < 6; j++) {
            if (map[i][j] != '.' && !visited[i][j]) {
                if (bfs(i, j, map[i][j])) {
                    isPopped = true;
                }
            }
        }
    }

    return isPopped;
}

void downPuyo() {
    for (int i = 0; i < 6; i++) {
        queue<char> q;
        for (int j = 11; j >= 0; j--) {
            if (map[j][i] != '.') {
                q.push(map[j][i]);
                map[j][i] = '.';
            }
        }

        int idx = 11;
        while (!q.empty()) {
            map[idx--][i] = q.front();
            q.pop();
        }
    }
}

int main() {
    for (int i = 0; i < 12; i++) {
        for (int j = 0; j < 6; j++) {
            cin >> map[i][j];
        }
    }

    int result = 0;
    while (true) {
        if (!popPuyo()) {
            break;
        }
        downPuyo();
        result++;
    }

    cout << result;

    return 0;
}
