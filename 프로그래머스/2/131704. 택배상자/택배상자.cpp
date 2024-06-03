#include <string>
#include <vector>
#include <stack>
#include <algorithm>

using namespace std;

int solution(vector<int> order) {
    int answer = 0;
    
    int max_val = order.size();
    stack<int> st;
    int idx = 1;
    
    for(auto& cur : order) {
        
        bool isPossible = false;
        // 큐에서 담을 수 있는 경우
        while(idx <= cur){
            if(idx == cur) {
                answer++;
                idx++;
                isPossible = true;
                break;
            }
            st.push(idx++);
        }
        
        if(isPossible)
            continue;
        
        if(!st.empty() && st.top() == cur){
            answer++;
            st.pop();
            continue;
        }else{
            break;
        }
        
    }
    
    return answer;
}