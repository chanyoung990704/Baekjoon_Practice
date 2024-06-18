#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

pair<int, int> get_y_x(int y, int x, char dir, vector<string>& board) {
    if (dir == 'L') {
        while (true) {
            int next = x - 1;
            if (next < 0 || board[y][next] == 'D')
                break;
            x = next;
        }
    } else if (dir == 'R') {
        while (true) {
            int next = x + 1;
            if (next >= board[0].size() || board[y][next] == 'D')
                break;
            x = next;
        }
    } else if (dir == 'U') {
        while (true) {
            int next = y - 1;
            if (next < 0 || board[next][x] == 'D')
                break;
            y = next;
        }
    } else if (dir == 'D') {
        while (true) {
            int next = y + 1;
            if (next >= board.size() || board[next][x] == 'D')
                break;
            y = next;
        }
    }
    return make_pair(y, x);
}

int solution(vector<string> board) {
    int sy = -1, sx = -1;
    int gy = -1, gx = -1;

    for (int i = 0; i < board.size(); i++) {
        for (int j = 0; j < board[0].size(); j++) {
            if (board[i][j] == 'R') {
                sy = i;
                sx = j;
            }
            if (board[i][j] == 'G') {
                gy = i;
                gx = j;
            }
        }
    }

    vector<vector<int>> dist(board.size(), vector<int>(board[0].size(), -1));
    queue<pair<int, int>> q;
    q.push({sy, sx});
    dist[sy][sx] = 0;

    while (!q.empty()) {
        int y = q.front().first;
        int x = q.front().second;
        q.pop();

        vector<char> directions = {'L', 'R', 'U', 'D'};
        for (char dir : directions) {
            pair<int, int> next = get_y_x(y, x, dir, board);
            int ny = next.first;
            int nx = next.second;

            if (dist[ny][nx] == -1) {
                dist[ny][nx] = dist[y][x] + 1;
                q.push({ny, nx});
            }
        }
    }

    return dist[gy][gx];
}