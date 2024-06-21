#include <string>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int solution(int n, int k, vector<int> enemy) {
    int answer = 0;
    
    long long total = 0;
    priority_queue<int> pq;
    
    for(auto& e : enemy) {
        total += e;
        pq.push(e);
        
        if(total > n) {
            
            if(k > 0) {
                total -= pq.top();
                pq.pop();
                k--;
            }
            else{
                break;
            }
            
        }
        
        answer++;
    }
    
    
    return answer;
}