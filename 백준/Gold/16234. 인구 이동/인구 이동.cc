#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};

// 국경 체크 및 인구 이동
bool isMerge(vector<vector<int>>& arr, int L, int R) {
    int N = arr.size();
    vector<vector<bool>> visited(N, vector<bool>(N, false));
    bool isPossible = false;

    for(int i = 0 ; i < N ; i++) {
        for(int j = 0 ; j < N ; j++) {
            if (!visited[i][j]) {
                queue<pair<int, int>> q;
                vector<pair<int, int>> unionCells;
                q.push({i, j});
                visited[i][j] = true;
                unionCells.push_back({i, j});
                int total = arr[i][j];
                int cnt = 1;

                while (!q.empty()) {
                    int cur_y = q.front().first;
                    int cur_x = q.front().second;
                    q.pop();

                    for (int k = 0; k < 4; k++) {
                        int next_y = cur_y + dy[k];
                        int next_x = cur_x + dx[k];

                        if (next_y >= 0 && next_y < N && next_x >= 0 && next_x < N && !visited[next_y][next_x]) {
                            int next_val = arr[next_y][next_x];
                            int val = abs(arr[cur_y][cur_x] - next_val);
                            if (val >= L && val <= R) {
                                q.push({next_y, next_x});
                                visited[next_y][next_x] = true;
                                unionCells.push_back({next_y, next_x});
                                total += next_val;
                                cnt++;
                                isPossible = true;
                            }
                        }
                    }
                }

                int new_total = total / cnt;
                for (auto cell : unionCells) {
                    arr[cell.first][cell.second] = new_total;
                }
            }
        }
    }

    return isPossible;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, L, R;
    cin >> N >> L >> R;

    vector<vector<int>> arr(N, vector<int>(N));

    for(int i = 0 ; i < N ; i++)
        for(int j = 0 ; j < N ; j++)
            cin >> arr[i][j];

    int result = 0;

    while(isMerge(arr, L, R)) {
        result++;
    }

    cout << result << "\n";
}