#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

const int MAX = 51;
int N, M;
int numMap[MAX][MAX];
int dp[MAX][MAX];

int solve(int y, int x) {

    if (dp[y][x] != -1) return dp[y][x]; // 이미 계산된 경우

    dp[y][x] = 1; // 기본값은 1
    int maxSize = max(N, M);
    for (int size = 1; size < maxSize; ++size) {
        // 범위 벗어난 경우 종료
        if (y + size >= N || x + size >= M)
            break;
        if (numMap[y][x] == numMap[y][x + size] &&
            numMap[y][x] == numMap[y + size][x] &&
            numMap[y][x] == numMap[y + size][x + size]) {
            dp[y][x] = max(dp[y][x], (size + 1) * (size + 1));
        }
    }

    return dp[y][x];
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        string tmp;
        cin >> tmp;
        for (int j = 0; j < tmp.size(); j++)
            numMap[i][j] = tmp[j] - '0';
    }

    // dp 배열 초기화
    for (int i = 0; i < N; i++)
        fill(dp[i], dp[i] + M, -1);

    int answer = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            answer = max(answer, solve(i, j));
        }
    }

    cout << answer;
    return 0;
}
