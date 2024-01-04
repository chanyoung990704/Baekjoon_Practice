#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>
#include <tuple>

using namespace std;

// 우 좌 상 하
int dy[4] = { 0,0,-1,1 };
int dx[4] = { 1,-1,0,0 };

// bfs로 풀기
int solution(vector<vector<int>> rectangle, int characterX, int characterY, int itemX, int itemY) {

    // 보드판 만들기
    vector<vector<int>> board(101, vector<int>(101, 0));

    for (int i = 0; i < rectangle.size(); i++) {
        int minX = rectangle[i][0] * 2; int maxX = rectangle[i][2] * 2;
        int minY = rectangle[i][1] * 2; int maxY = rectangle[i][3] * 2;

        for (int j = minX; j <= maxX; j++) {
            board[minY][j] = 1;
            board[maxY][j] = 1;
        }

        for (int j = minY; j <= maxY; j++) {
            board[j][minX] = 1;
            board[j][maxX] = 1;
        }
    }

    for (int i = 0; i < rectangle.size(); i++) {
        int minX = rectangle[i][0] * 2; int maxX = rectangle[i][2] * 2;
        int minY = rectangle[i][1] * 2; int maxY = rectangle[i][3] * 2;

        for (int j = minX + 1; j < maxX; j++)
            for (int k = minY + 1; k < maxY; k++) {
                board[k][j] = 0;
            }
    }

    // BFS
    int answer = 0;
    characterX *= 2;    characterY *= 2;
    itemX *= 2; itemY *= 2;

    vector<vector<bool>> visited(101, vector<bool>(101, false));
    queue<tuple<int, int, int>> q;
    visited[characterY][characterX] = true;
    q.push(make_tuple(characterY, characterX, 0));

    while (!q.empty()) {
        int curY = get<0>(q.front());
        int curX = get<1>(q.front());
        int cnt = get<2>(q.front());
        q.pop();

        if (curY == itemY && curX == itemX)
            return cnt / 2;

        for (int i = 0; i < 4; i++) {
            int nextY = curY + dy[i];
            int nextX = curX + dx[i];

            if (nextY >= 1 && nextY <= 100 && nextX >= 1 && nextX <= 100
                && !visited[nextY][nextX] && board[nextY][nextX] == 1) {
                visited[nextY][nextX] = true;
                q.push(make_tuple(nextY, nextX, cnt + 1));
            }


        }


    }

    return answer;
}