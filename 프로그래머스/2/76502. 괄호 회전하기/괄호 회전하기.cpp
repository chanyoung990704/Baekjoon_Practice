#include <string>
#include <vector>
#include <stack>

using namespace std;


bool isBalanced(string s){
    stack<char> st;
    
    for(auto& c : s){
        if(!st.empty()){
            char t = st.top();
            
            if(c == ']' && t == '['){
                st.pop();
                continue;
            }else if(c == ')' && t == '('){
                st.pop();
                continue;
            }else if(c == '}' && t == '{'){
                st.pop();
                continue;
            }
        }
        
        st.push(c);
    }
    return st.empty();

}


int solution(string s) {
    int answer = 0;
    
    string ss = s + s;
    
    for(int i = 0 ; i < s.size() ; i++){
        string tmp = ss.substr(i, s.size());
        if(isBalanced(tmp))
            answer++;
    }
    
    
    return answer;
}