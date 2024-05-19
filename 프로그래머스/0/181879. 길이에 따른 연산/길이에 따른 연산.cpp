#include <string>
#include <vector>

using namespace std;

int solution(vector<int> num_list) {
    int answer = 0;
    // 리스트의 길이가 11이상
    // 모든 원소 합
    if(num_list.size() >= 11) {
        for(auto n : num_list)
            answer += n;
    }
    // 리스트의 길이 10 이하
    // 모든 원소 곱
    else{
        answer = 1;
        for(auto n : num_list)
            answer *= n;
    }
    
    
    return answer;
}