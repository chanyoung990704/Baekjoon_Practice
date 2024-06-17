#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>
#include <tuple>

using namespace std;

int dy[4] = {0, 0, 1, -1};
int dx[4] = {1, -1, 0, 0};

// BFS 함수: 바이러스가 퍼진 후 남은 빈 칸의 수를 계산
int bfs(const vector<vector<int>>& maps) {
    queue<pair<int, int>> q;
    vector<vector<bool>> visited(maps.size(), vector<bool>(maps[0].size(), false));

    // 초기 바이러스 위치를 큐에 추가
    for (int i = 0; i < maps.size(); i++) {
        for (int j = 0; j < maps[0].size(); j++) {
            if (maps[i][j] == 2) {
                q.emplace(i, j);
                visited[i][j] = true;
            }
        }
    }

    // BFS를 통해 바이러스 퍼뜨리기
    while (!q.empty()) {
        int cur_y = q.front().first;
        int cur_x = q.front().second;
        q.pop();

        for (int i = 0; i < 4; i++) {
            int ny = cur_y + dy[i];
            int nx = cur_x + dx[i];

            if (ny >= 0 && ny < maps.size() && nx >= 0 && nx < maps[0].size() && 
                !visited[ny][nx] && maps[ny][nx] == 0) {
                visited[ny][nx] = true;
                q.emplace(ny, nx);
            }
        }
    }

    // 남은 빈 칸의 수 계산
    int empty_count = 0;
    for (int i = 0; i < maps.size(); i++) {
        for (int j = 0; j < maps[0].size(); j++) {
            if (maps[i][j] == 0 && !visited[i][j]) {
                empty_count++;
            }
        }
    }

    return empty_count;
}

// solve 함수: 벽을 세우는 모든 경우의 수를 탐색하여 최대 빈 칸 수를 계산
int solve(vector<vector<int>>& maps, int wall_count) {
    if (wall_count == 3) {
        return bfs(maps);
    }

    int max_empty = 0;
    for (int i = 0; i < maps.size(); i++) {
        for (int j = 0; j < maps[0].size(); j++) {
            if (maps[i][j] == 0) {
                maps[i][j] = 1;
                max_empty = max(max_empty, solve(maps, wall_count + 1));
                maps[i][j] = 0;
            }
        }
    }

    return max_empty;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int N, M;
    cin >> N >> M;

    vector<vector<int>> maps(N, vector<int>(M));
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> maps[i][j];
        }
    }

    cout << solve(maps, 0) << "\n";
    return 0;
}