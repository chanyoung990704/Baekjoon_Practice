#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    
    int totalTime = 0; // 경과시간
    vector<int> truckIn(truck_weights.size(), 0); // 트럭이 처음 다리에 진입한 시간
    int totalWeight = 0; // 현재 다리에 트럭 무게
    queue<int> q; // 다리에 있는 트럭 무게
    
    int idx = 0;
    while(idx < truck_weights.size()) {
        // 경과 시간 증가
        totalTime++;
        
        // 다리에 차가 빠져나갈 수 있으면
        if(!q.empty() && totalTime - truckIn[q.front()] >= bridge_length) {
            // 무게 감소
            totalWeight -= truck_weights[q.front()];
            q.pop();
        }
        
        // 다리에 차가 진입할 수 있으면
        if(totalWeight + truck_weights[idx] <= weight) {
            // 무게 증가
            totalWeight += truck_weights[idx];
            // 큐에 삽입
            q.push(idx);
            // 시간 업데이트
            truckIn[idx] = totalTime;
            // 다음 트럭으로 이동
            idx++;
        }
    }
    
    // 마지막 트럭 시간 고려
    return totalTime + bridge_length;
}