#include <string>
#include <math.h>
#include <vector>
using namespace std;

int solution(string dartResult) {
    int answer = 0;
    vector<int> scores(3, 0);
    int idx = -1;
    
    for(int i = 0 ; i < dartResult.size() ; i++) {
        
        char cur = dartResult[i];
        
        if(isdigit(cur)){
            idx++;
            if(cur == '1' && dartResult[i + 1] == '0'){
                scores[idx] = 10;
                i++;
            }else{
                scores[idx] = cur - '0';
            }
        }else if(cur == 'D')
            scores[idx] = pow(scores[idx], 2);
        else if(cur == 'T')
            scores[idx] = pow(scores[idx], 3);
        else if(cur == '#')
            scores[idx] *= -1;
        else if(cur == '*'){
            scores[idx] *= 2;
            if(idx > 0)
                scores[idx - 1] *= 2; 
        }
        
        
        
        
    }
    
    for(auto s : scores)
        answer += s;
    
    return answer;
}