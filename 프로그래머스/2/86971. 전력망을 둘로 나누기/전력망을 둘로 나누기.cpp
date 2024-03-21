#include <string>
#include <vector>
#include <algorithm>
#include <math.h>

using namespace std;

int dfs(int cur, vector<bool>& visited, vector<vector<int>>& adj,
       int from, int to) {
    int ret = 1;
    visited[cur] = true;
    
    for(int next : adj[cur]){
        if((cur == from && next == to) || (cur == to && next == from))
            continue;
        
        if(!visited[next]){
            ret += dfs(next, visited, adj, from, to);
        }
    }
    return ret;
}

int solution(int n, vector<vector<int>> wires) {
    
    // dfs
    vector<vector<int>> adj(n + 1);
    
    for(vector<int> wire : wires) {
        adj[wire[0]].push_back(wire[1]);
        adj[wire[1]].push_back(wire[0]);
    }
    
    int ret = 987654321;
    for(vector<int> wire : wires) {
        vector<bool> visited(n + 1, false); // 1 ~ n개
        int from = wire[0]; int to = wire[1];
        vector<int> result;
        for(int i = 1 ; i <= n ; i++)
            if(!visited[i])
                result.push_back(dfs(i, visited, adj, from, to));
        ret = min(ret, abs(result[0] - result[1]));
    }
    
    return ret;
    
}