#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(string s) {
    int answer = s.size();  // 초기 값을 문자열의 길이로 설정
    
    for(int i = 1 ; i <= s.size() / 2 ; i++) {
        
        string prev = s.substr(0, i);  // 첫 번째 부분 문자열 초기화
        string result = "";
        size_t s_idx = i;
        int cnt = 1;
        
        while(s_idx < s.size()) {
            // 문자열 분해
            string tmp = s.substr(s_idx, i);
            
            if(prev != tmp) {
                if(cnt > 1){
                    result.append(to_string(cnt));
                }
                result.append(prev);
                
                cnt = 1;
                prev = tmp;
                
            } else {
                cnt++;
            }
            
            s_idx += i;
        }
        
        // 마지막 부분 처리
        if(cnt > 1) {
            result.append(to_string(cnt));
        }
        result.append(prev);
        
        // answer 갱신
        int tmp_res = result.size();
        answer = min(answer, tmp_res);
    }    
    
    return answer;
}