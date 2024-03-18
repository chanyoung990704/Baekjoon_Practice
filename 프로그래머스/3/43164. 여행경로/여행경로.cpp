#include <string>
#include <vector>
#include <algorithm>

using namespace std;

// dfs
bool dfs(vector<vector<string>>& tickets, vector<string>& result, vector<bool>& visited, string cur) {
    
    if(result.size() == tickets.size() + 1)
        return true;
    
    for(int i = 0 ; i < tickets.size() ; i++) {
        if(!visited[i] && tickets[i][0] == cur) {
            visited[i] = true;
            result.push_back(tickets[i][1]);
            if(dfs(tickets, result, visited, tickets[i][1]))
                return true;
            result.pop_back();
            visited[i] = false;
        }
    }
    
    return false;
}

vector<string> solution(vector<vector<string>> tickets) {
    
    vector<string> result;
    result.push_back("ICN");
    vector<bool> visited(tickets.size(), false);
    
    sort(tickets.begin(), tickets.end());
    
    dfs(tickets, result, visited, "ICN");
    
    return result;
}