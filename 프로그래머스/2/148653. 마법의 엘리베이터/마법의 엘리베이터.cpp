#include <string>
#include <vector>
#include <algorithm>
#include <stack>

using namespace std;

int solution(int storey) {
    int answer = 0;
    
    stack<int> st;
    
    string s_num = to_string(storey);
    for(auto& c : s_num)
        st.push(c - '0');
    
    while(!st.empty()) {
        int cur = st.top();
        st.pop();
        
        if(cur < 5) {
            answer += cur;
        } else if(cur > 5) {
            answer += (10 - cur);
            if(!st.empty()) {
                int next = st.top();
                st.pop();
                st.push(next + 1);
            } else {
                st.push(1);
            }
        } else { // cur == 5
            if(!st.empty() && st.top() >= 5) {
                int next = st.top();
                st.pop();
                st.push(next + 1);
            }
            answer += 5;
        }
    }
    
    return answer;
}