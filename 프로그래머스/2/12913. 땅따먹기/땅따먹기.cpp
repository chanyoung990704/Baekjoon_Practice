#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int dfs(vector<vector<int>>& land, vector<vector<int>>& memo, int row, int col) {
    // 마지막 행에 도달하면 현재 칸의 값을 반환
    if (row == land.size() - 1) {
        return land[row][col];
    }

    // 이미 계산된 값이 있으면 그 값을 반환
    if (memo[row][col] != -1) {
        return memo[row][col];
    }

    int maxScore = 0;
    for (int i = 0; i < 4; i++) {
        if (i != col) {
            maxScore = max(maxScore, dfs(land, memo, row + 1, i));
        }
    }

    // 현재 칸의 값을 더한 후 메모이제이션
    memo[row][col] = land[row][col] + maxScore;
    return memo[row][col];
}

int solution(vector<vector<int>> land) {
    int n = land.size();
    vector<vector<int>> memo(n, vector<int>(4, -1));
    int result = 0;

    // 첫 번째 행의 각 칸에서 시작하여 최대 점수를 찾음
    for (int i = 0; i < 4; i++) {
        result = max(result, dfs(land, memo, 0, i));
    }

    return result;
}
