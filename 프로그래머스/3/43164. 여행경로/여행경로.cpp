#include <string>
#include <vector>
#include <algorithm>
using namespace std;

bool dfs(vector<vector<string>>& tickets, vector<string>& answer, vector<bool>& visited, string start, int cnt) {
    answer.push_back(start);

    if (cnt == 0) return true;

    for (int i = 0; i < tickets.size(); i++) {
        if (!visited[i] && tickets[i][0] == start) {
            visited[i] = true;
            string dest = tickets[i][1];
            if (dfs(tickets, answer, visited, dest, cnt - 1)) return true;
            visited[i] = false;
        }
    }

    answer.pop_back();
    return false;
}

vector<string> solution(vector<vector<string>> tickets) {
    vector<string> answer;
    vector<bool> visited(tickets.size(), false); // 티켓 사용 여부를 저장하는 visited 배열
    sort(tickets.begin(), tickets.end());
    dfs(tickets, answer, visited, "ICN", tickets.size());
    return answer;
}
