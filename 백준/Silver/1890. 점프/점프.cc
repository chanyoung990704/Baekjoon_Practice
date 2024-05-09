#include <iostream>
#include <vector>
using namespace std;

int n;
vector<vector<int>> board;
vector<vector<long long>> dp;

long long dfs(int x, int y) {
    // 기저 사례: (n-1, n-1)에 도달한 경우 1 반환
    if (x == n - 1 && y == n - 1) return 1;

    // 이미 계산된 경우 dp 값 반환
    if (dp[x][y] != -1) return dp[x][y];

    dp[x][y] = 0;
    int jump = board[x][y];

    // 오른쪽으로 이동 가능한 경우
    if (y + jump < n) {
        dp[x][y] += dfs(x, y + jump);
    }

    // 아래로 이동 가능한 경우
    if (x + jump < n) {
        dp[x][y] += dfs(x + jump, y);
    }

    return dp[x][y];
}

int main() {
    cin >> n;
    board.assign(n, vector<int>(n, 0));
    dp.assign(n, vector<long long>(n, -1));

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> board[i][j];
        }
    }

    cout << dfs(0, 0) << "\n";
    return 0;
}