#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> queue1, vector<int> queue2) {
    
    int q_size = queue1.size();
    
    int q1_cnt = 0;
    int q2_cnt = 0;
    int total_cnt = 0;
    
    unsigned long long q1_total = 0;
    unsigned long long q2_total = 0;
    
    queue<int> q1;
    for(auto& n : queue1){
        q1.push(n);
        q1_total += n;
    }
    
    queue<int> q2;
    for(auto& n : queue2){
        q2.push(n);
        q2_total += n;
    }
    
    while(true) {
        
        // 현재 큐가 같은지 확인
        if(q1_total == q2_total)
            break;
        
        if(q1_cnt >= q_size && q2_cnt >= q_size){
            total_cnt = -1;
            break;
        }
        
        // 큰 쪽에서 작은 쪽으로 옮기기
        if(q1_total > q2_total){
            q2.push(q1.front());
            q1_total -= q1.front();
            q2_total += q1.front();
            q1.pop();
            total_cnt++;
            q1_cnt++;
        }else if(q1_total < q2_total){
            q1.push(q2.front());
            q1_total += q2.front();
            q2_total -= q2.front();
            q2.pop();
            total_cnt++;
            q2_cnt++;
        }
        
    }
    
    return total_cnt;
}