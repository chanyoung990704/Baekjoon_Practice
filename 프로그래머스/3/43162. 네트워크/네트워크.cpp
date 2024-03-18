#include <string>
#include <vector>

using namespace std;

void dfs(vector<vector<int>>& computers, vector<bool>& visited, int cur) {
    
    visited[cur] = true;
    for(int i = 0 ; i < computers[cur].size() ; i++) {
        if(computers[cur][i] == 1)
            if(!visited[i])
                dfs(computers, visited, i);
    }
}

int solution(int n, vector<vector<int>> computers) {
    
    vector<bool> visited(n, false);
    int cnt = 0;
    for(int i = 0 ; i < n ; i++)
        if(!visited[i]) {
            dfs(computers, visited, i);
            cnt++;
        }

    return cnt;
}