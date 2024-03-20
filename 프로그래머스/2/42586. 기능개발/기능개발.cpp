#include <string>
#include <vector>
#include <queue>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {

    // 큐에 소요되는 일수 저장
    queue<int> q;
    for(int i = 0 ; i < progresses.size() ; i++) {
        int remainProgress = 100 - progresses[i];
        int days = remainProgress % speeds[i] == 0 ? remainProgress / speeds[i] : remainProgress / speeds[i] + 1;
        q.push(days);
    }
    
    vector<int> result;
    // 큐 순회
    while(!q.empty()) {
        int cnt = 1;
        int curDays = q.front();
        q.pop();
        
        while(!q.empty() && q.front() <= curDays) {
            // 다음 작업 처리
            cnt++;
            q.pop();
        }
        
        result.push_back(cnt);
    }
    return result;
}