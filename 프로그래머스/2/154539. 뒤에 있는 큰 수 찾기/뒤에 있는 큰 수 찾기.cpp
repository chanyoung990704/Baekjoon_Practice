#include <string>
#include <vector>
#include <stack>

using namespace std;

vector<int> solution(vector<int> numbers) {
    vector<int> answer(numbers.size());
    stack<pair<int, int>> st;
    
    for(int i = 0 ; i < numbers.size() ; i++) {
        
        int cur = numbers[i];
        
        while(!st.empty() && st.top().first < cur){
            answer[st.top().second] = cur;
            st.pop();
        }
        
        st.push(make_pair(cur, i));
        
    }
    
    while(!st.empty()){
        answer[st.top().second] = -1;
        st.pop();
    }
    
    return answer;
}