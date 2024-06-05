#include <string>
#include <vector>
#include <algorithm>
#include <stack>

using namespace std;

string solution(string number, int k) {
    string answer = "";
    
    stack<char> st;
    
    for(auto& cur : number){
        while(!st.empty() && k > 0 && st.top() < cur){
            st.pop();
            k--;
        }
        st.push(cur);
    }
    
    while(k > 0) {
        st.pop();
        k--;
    }
    
    while(!st.empty()) {
        answer.push_back(st.top());
        st.pop();
    }
    
    reverse(answer.begin(), answer.end());
    
    return answer;
}