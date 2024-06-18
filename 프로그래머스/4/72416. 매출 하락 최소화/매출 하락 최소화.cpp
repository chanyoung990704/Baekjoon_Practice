#include <string>
#include <vector>
#include <algorithm>

using namespace std;

void dfs(int cur, vector<int>& sales, vector<vector<int>>& adj,
         vector<vector<int>>& dp) {
    
    if(adj[cur].empty())
        return;
    
    int additional_cost = 1e9;
    
    // 자식들 
    for(auto& next : adj[cur]) {
        dfs(next, sales, adj, dp);
        
        int next_val = min(dp[next][0], dp[next][1]);
        dp[cur][0] += next_val;
        dp[cur][1] += next_val;
        
        if(next_val == dp[next][0])
            additional_cost = min(additional_cost, dp[next][1] - dp[next][0]);
        else
            additional_cost = 0;
        
    }
    
    dp[cur][0] += additional_cost;
    
}

int solution(vector<int> sales, vector<vector<int>> links) {
    int answer = 1e9;
    
    vector<vector<int>> adj(sales.size());
    for(auto& link : links)
        adj[link[0] - 1].push_back(link[1] - 1);
    
    vector<vector<int>> dp(sales.size(), vector<int>(2, 0));
    for(int i = 0 ; i < sales.size() ; i++)
        dp[i][1] = sales[i];
    
    dfs(0, sales, adj, dp);
    
    answer = min(dp[0][0], dp[0][1]);
    
    return answer;
}