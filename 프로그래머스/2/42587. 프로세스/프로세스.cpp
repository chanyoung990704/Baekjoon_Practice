#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> priorities, int location) {

    // 큐와 우선순위 큐에 동시 사용
    priority_queue<int> pq;
    queue<pair<int,int>> q; // 우선순위, idx;
    
    for(int i = 0 ; i < priorities.size() ; i++) {
        pq.push(priorities[i]);
        q.push(make_pair(priorities[i], i));
    }
    
    int cnt = 0;
    // 큐 순회
    while(!q.empty()) {
        // 큐에서 하나 꺼낸다.
        int curPriority = q.front().first;
        int curIdx = q.front().second;
        q.pop();
        
        // 대기 프로세스 중 우선순위가 더 높은지 확인한다.
        if(pq.top() > curPriority) {
            q.push(make_pair(curPriority, curIdx));
        }
        else {
            // 프로세스 실행한다.
            cnt++;
            pq.pop();
            if(curIdx == location)
                break;
        } 
    }
    
    return cnt;
}