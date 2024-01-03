#include <iostream>
#include <vector>
#include <queue>
using namespace std;

char direction[4] = {'d', 'l', 'r', 'u'};
int dy[4] = {1, 0, 0, -1};
int dx[4] = {0, -1, 1, 0};

string solution(int n, int m, int x, int y, int r, int c, int k) {
    vector<vector<vector<bool>>> visited(n, vector<vector<bool>>(m, vector<bool>(k + 1, false)));
    queue<pair<pair<int, int>, pair<string, int>>> q;
    q.push({{x - 1, y - 1}, {"", 0}});
    visited[x - 1][y - 1][0] = true;

    while (!q.empty()) {
        int curY = q.front().first.first;
        int curX = q.front().first.second;
        string path = q.front().second.first;
        int count = q.front().second.second;
        q.pop();

        if (curY == r - 1 && curX == c - 1 && count == k) {
            return path;
        }

        for (int i = 0; i < 4; i++) {
            int newY = curY + dy[i];
            int newX = curX + dx[i];
            int newCount = count + 1;
            if (newY >= 0 && newY < n && newX >= 0 && newX < m && newCount <= k && !visited[newY][newX][newCount]) {
                q.push({{newY, newX}, {path + direction[i], newCount}});
                visited[newY][newX][newCount] = true;
            }
        }
    }
    return "impossible";
}