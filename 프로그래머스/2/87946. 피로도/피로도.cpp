#include <string>
#include <algorithm>
#include <vector>

using namespace std;

void maxDungeons(int k, vector<vector<int>>& dungeons, int cnt,
                vector<bool>& visited, vector<int>& result) {
    
    if(cnt > 0)
        result.push_back(cnt);
        
    for(int i = 0 ; i < dungeons.size() ; i++) {
        if(!visited[i] && k >= dungeons[i][0]) {
            visited[i] = true;
            maxDungeons(k - dungeons[i][1], dungeons, cnt + 1, visited, result);
            visited[i] = false;
        }
    }

}

int solution(int k, vector<vector<int>> dungeons) {
    vector<bool> visited(dungeons.size(), false);
    vector<int> result;
    maxDungeons(k, dungeons, 0, visited, result);
    sort(result.begin(), result.end());
    
    return result[result.size() - 1];
}
