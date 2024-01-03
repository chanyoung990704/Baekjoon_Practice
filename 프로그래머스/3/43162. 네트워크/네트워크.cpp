#include <iostream>
#include <vector>

using namespace std;

void dfs(const vector<vector<int>>& computers, vector<int>&visited, const int& startIdx, const int& n) {
    visited[startIdx] = true;

    for (int i = 0; i < n; i++) {
        if (!visited[i] && computers[startIdx][i] == 1)
            dfs(computers, visited, i, n);
    }
}

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    vector<int> visited(n, false);

    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            dfs(computers, visited, i, n);
            answer++;
        }
    }

    return answer;
}