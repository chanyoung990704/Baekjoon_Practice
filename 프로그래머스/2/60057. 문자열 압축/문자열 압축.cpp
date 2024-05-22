#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(string s) {
    int answer = s.size();
    
    for(int step = 1 ; step <= (s.size() / 2) ; step++){
        string compressed = "";
        string prev = s.substr(0, step);
        int cnt = 1;
        
        for(int j = step ; j < s.size() ; j += step){
            string sub_s = s.substr(j, step);
            if(sub_s == prev)
                cnt += 1;
            else{
                if(cnt > 1)
                    compressed.append(to_string(cnt));
                compressed.append(prev);
                prev = sub_s;
                cnt = 1;
            }
                
        }
        
        if(cnt > 1)
            compressed.append(to_string(cnt));
        compressed.append(prev);
        
        answer = min(answer, (int)compressed.size());
    }
    
    
    
    return answer;
}