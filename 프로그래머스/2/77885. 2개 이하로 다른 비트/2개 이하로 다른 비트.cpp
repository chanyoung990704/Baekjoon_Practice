#include <string>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

vector<long long> solution(vector<long long> numbers) {
    vector<long long> answer;
    
    for(auto& number : numbers) {
        
        if(number % 2 == 0)
            answer.push_back(number + 1);
        else {
            // 홀수일 때
            
            // 2진수 변환
            string tmp_binary = "";
            long long tmp_num = number;
            
            while(tmp_num > 0) {
                tmp_binary.append(to_string(tmp_num % 2));
                tmp_num /= 2;
            }
            
            // 2진수 마지막에 0추가
            tmp_binary.append("0");
            
            reverse(tmp_binary.begin(), tmp_binary.end());
            
            // 가장 오른쪽에 0위치 찾기
            size_t idx = tmp_binary.size() - 1;
            while(idx > 0 && tmp_binary[idx] != '0') {
                idx--;
            }
            
            // 0을 1로, 그 다음 비트 0으로 변경
            tmp_binary[idx] = '1';
            tmp_binary[idx + 1] = '0';
            
            // 이진수 10진수 계산
            long long total = 0;
            for(size_t i = 0; i < tmp_binary.size(); ++i) {
                if(tmp_binary[i] == '1')
                    total += (1LL << (tmp_binary.size() - 1 - i));
            }
            
            answer.push_back(total);
        }
        
    }
    
    return answer;
}
