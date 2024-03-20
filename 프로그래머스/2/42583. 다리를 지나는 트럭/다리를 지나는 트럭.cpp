#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int answer = 0;
    int total_weight = 0;
    queue<int> q;

    // 트럭이 다리를 건너는 시간을 나타내는 변수
    vector<int> time(truck_weights.size(), 0);

    int idx = 0;
    while (idx < truck_weights.size()) {
        answer++; // 시간 증가

        // 다리의 맨 앞에 있는 트럭이 다리를 건넌 경우
        if (!q.empty() && answer - time[q.front()] >= bridge_length) {
            total_weight -= truck_weights[q.front()]; // 다리 위 트럭의 무게 감소
            q.pop(); // 다리에서 트럭 제거
        }

        // 현재 다리에 올릴 수 있는 경우
        if (total_weight + truck_weights[idx] <= weight) {
            q.push(idx); // 트럭 추가
            total_weight += truck_weights[idx]; // 다리 위 트럭의 무게 증가
            time[idx] = answer; // 트럭이 다리에 올라간 시간 기록
            idx++; // 다음 트럭으로 이동
        }
    }

    // 마지막 트럭이 다리를 지날 때까지의 시간에 다리의 길이를 더해준다.
    answer += bridge_length;

    return answer;
}
