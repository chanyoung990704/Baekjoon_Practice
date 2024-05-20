#include <string>
#include <vector>

using namespace std;

string solution(string s, int n) {
    string answer = "";
    
    for(auto c : s) {
        
        // 0 ~ 25
        // 26으로 나누기
        if(c == ' '){
            answer.append(" ");
            continue;
        }
        
        if(islower(c)){
            
            int idx = (c - 'a' + n) % 26;
            char cur = 'a' + idx;
            answer.push_back(cur);
            
        }else{
            int idx = (c - 'A' + n) % 26;
            char cur = 'A' + idx;
            answer.push_back(cur);
        }
        
    }
    
    return answer;
}