#include <string>
#include <vector>
#include <map>
#include <set>

using namespace std;

vector<int> solution(vector<string> id_list, vector<string> report, int k) {

    // 이름 idx 매핑
    map<string, int> nameIdx;
    for (int i = 0; i < id_list.size(); i++)
        nameIdx[id_list[i]] = i;

    vector<int> reported(id_list.size(), 0); // 신고당한 횟수.
    // adj 간선 생성 및 신고당한 횟수 업데이트
    vector<set<int>> adj(id_list.size());
    for (string s : report) {
        string from = s.substr(0, s.find(' '));
        string to = s.substr(s.find(' ') + 1);

        int fromIdx = nameIdx[from];    int toIdx = nameIdx[to];
        // 초기 신고
        if (adj[fromIdx].count(toIdx) == 0) {
            adj[fromIdx].insert(toIdx);
            reported[toIdx]++;
        }
    }

    // 신고 횟수 추가 확인
    set<int> stopIdx; // 정지 회원Idx
    for (int i = 0; i < reported.size(); i++) {
        if (reported[i] >= k)
            stopIdx.insert(i);
    }
    // adj 간선 확인하면서 result 업데이트
    vector<int> result;
    for (int i = 0; i < id_list.size(); i++) {
        int cnt = 0;
        for (int r : adj[i])
            if (stopIdx.count(r) != 0)
                cnt++;

        result.push_back(cnt);
    }

    return result;

}