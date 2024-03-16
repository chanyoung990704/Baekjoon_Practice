#include<string>
#include <iostream>
#include <stack>

using namespace std;

bool solution(string s)
{
    stack<char> st;
    for(char c : s) {
        // 여는 괄호면 무조건 푸시
        if(c == '(')
            st.push(c);
        
        // 닫는 괄호이면
        if(c == ')') {
            if(st.empty())
                return false;
            else
                st.pop();
        }
    }
    
    return st.empty();
}