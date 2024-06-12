#include <string>
#include <vector>
#include <stack>
#include <algorithm>

using namespace std;

// 0부터 문자열 검사해서 분리할 idx 리턴
int get_sub_idx(string s) {
    int l = 0;
    int r = 0;
    
    for(int i = 0 ; i < s.size() ; i++) {
        if(s[i] == '(')
            l++;
        else if(s[i] == ')')
            r++;
        
        if(l == r)
            return i;
    }
    
    return -1;
}

// 올바른 괄호 문자열인지 확인하는 함수
bool is_right_str(string s) {
    
    stack<char> st;
    
    for(auto& cur : s) {
        
        if(cur == '('){
            st.push(cur);
        }else if(cur == ')') {
            if(!st.empty() && st.top() == '(') {
                st.pop();
            }
            else{
                return false;
            }
        }
        
        
    }
    
    if(!st.empty())
        return false;
    
    return true;
    
}

// 메인로직
string solve(string p) {
    
    // 빈 문자열이면 빈 문자열 반환
    if(p.empty())
        return "";
    
    
    // 문자열 분리
    string u = p.substr(0, get_sub_idx(p) + 1);
    string v = p.substr(get_sub_idx(p) + 1);
    
    // u가 올바른 괄호 문자열이면
    if(is_right_str(u)) {
        // v에 대해 재귀
        return u + solve(v);
    }
    else{
        string tmp = "(" + solve(v) + ")";
        // u의 첫번째와 마지막 문자 제거
        u.erase(0, 1);
        u.erase(u.size() - 1, 1);
        // 나머지 문자열 괄호 뒤집기
        for(auto& c : u){
            if(c == ')')
                c = '(';
            else if(c == '(')
                c = ')';
        }
        
        tmp = tmp + u;
        
        return tmp;
    }
    
    
    return "break";
}

string solution(string p) {
    string answer = "";
    
    if(is_right_str(p))
        return p;
    else
        return solve(p);
    
    return answer;
}