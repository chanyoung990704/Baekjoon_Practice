#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int dfs(vector<int>& numbers, vector<vector<bool>>& visited, int target, int cur, int curNum) {
    // Base case
    if(cur == numbers.size()) {
        return curNum == target ? 1 : 0;
    }
    
    int ret = 0;
    // 음수일 경우
    if(!visited[cur][0]) {
        visited[cur][0] = true;
        ret += dfs(numbers, visited, target, cur + 1, curNum - numbers[cur]);
        visited[cur][0] = false;
    }
    
    // 양수일 경우
    if(!visited[cur][1]) {
        visited[cur][1] = true;
        ret += dfs(numbers, visited, target, cur + 1, curNum + numbers[cur]);
        visited[cur][1] = false;
    }
    
    return ret;
    
}

int solution(vector<int> numbers, int target) {
    // [원소 idx][0] -> 음수, [원소 idx][1] -> 양수
    vector<vector<bool>> visited(numbers.size(), vector<bool>(2, false));
    int result = 0;
    result = dfs(numbers, visited, target, 0, 0);
    return result;
}
