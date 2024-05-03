#include <string>
#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int solution(vector<int> scoville, int K) {
    
    // 최소 힙
    priority_queue<int, vector<int>, greater<int>> pq;
    for(auto s : scoville)
        pq.push(s);
    
    // 로직
    int cnt = 0;
    while(!pq.empty()) {
        // 1이면 종료
        if(pq.size() == 1)
            break;
        
        // 2개 이상일 경우
        int cur = pq.top();
        if(cur >= K)
            break;
        // 재조합 필요한 경우
        pq.pop();
        int next = pq.top();
        pq.pop();
        pq.push(cur + next * 2);
        // 재조합 횟수 증가
        cnt++;
    
    }
    
    // 큐가 1개있을 때 검증
    if(pq.size() == 1)
        if(pq.top() < K)
            cnt = -1;
    
    return cnt;
}