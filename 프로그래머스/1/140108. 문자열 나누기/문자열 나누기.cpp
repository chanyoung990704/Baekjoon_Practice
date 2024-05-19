#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    int answer = 0;
    int i = 0;
    
    while(i < s.length()) {
        char x = s[i];
        int x_cnt = 0;
        int other_cnt = 0;
        
        while(i < s.length()) {
            if(s[i] == x)
                x_cnt++;
            else
                other_cnt++;
            i++;
            
            if(x_cnt == other_cnt)
                break;
        }
        
        answer++;
    }
    
    return answer;
}